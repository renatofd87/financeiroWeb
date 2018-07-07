package com.financeiro.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.financeiro.dto.Categoria;
import com.financeiro.dto.Conta;
import com.financeiro.dto.Despesa;
import com.financeiro.dto.DespesasGeral;
import com.financeiro.entities.CategoriaEntity;
import com.financeiro.entities.ContaEntity;
import com.financeiro.entities.DespesaEntity;
import com.financeiro.entities.UsuarioEntity;
import com.financeiro.repository.DespesasRepository;
import com.financeiro.repository.UsuarioRepository;
import com.financeiro.util.Constantes;
import com.financeiro.util.Moeda;

@Service
public class DespesaService {

	@Autowired
	private DespesasRepository despesas;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Despesa> buscarTudo(){
		List<DespesaEntity> despesasEntity = despesas.findAllOrderBydatadespesa();
		List<Despesa> despesasDTO = new ArrayList<>();
		
		for(DespesaEntity de:despesasEntity){
			Despesa despesa = new Despesa();
			despesa = this.toDespesaDTO(de);
			
			despesasDTO.add(despesa);
		}
		
		return despesasDTO;
	}
	
	public DespesasGeral buscarDespesasPorMesAno(Long mes, Long ano, String usuario){
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		GregorianCalendar calendarFixa = new GregorianCalendar();
		calendarFixa.setTime( new Date() );
		
		int diaFixa = calendarFixa.getActualMaximum( Calendar.DAY_OF_MONTH );
		int mesFixa = Integer.parseInt(mes.toString()) - 1;
		int anoFixa = Integer.parseInt(ano.toString());
		
		calendarFixa.set(GregorianCalendar.DAY_OF_MONTH, diaFixa);
		calendarFixa.set(GregorianCalendar.MONTH, mesFixa);
		calendarFixa.set(GregorianCalendar.YEAR, anoFixa);
		
		
		UsuarioEntity usuarioLogado = usuarioRepository.findByUsuario(usuario);
		System.out.println("Mes "+mes);
		System.out.println("ano "+ano);
		System.out.println("usuarioLogado.getIdusuario() "+usuarioLogado.getIdusuario());
		List<DespesaEntity> despesasEntity = despesas.buscarDespesasPorMesAno(mes, ano, usuarioLogado.getIdusuario());
		
		List<Despesa> despesas = new ArrayList<>();
		DespesasGeral geral = new DespesasGeral();
		
		BigDecimal despesaspendentes = BigDecimal.ZERO;
		BigDecimal despesaspagas = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		
		if(despesasEntity != null && despesasEntity.size() > BigInteger.ZERO.intValue()){
			for(DespesaEntity de:despesasEntity){
				Despesa despesa = new Despesa();
				despesa = this.toDespesaDTO(de);
				if(de.isFixa()){
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(de.getDatadespesa());
					
					calendar.set(GregorianCalendar.MONTH, mesFixa);
					calendar.set(GregorianCalendar.YEAR, anoFixa);
					
					despesa.setDatadespesa(format.format(calendar.getTime()));
				}
				System.out.println("despesa VALOR PAGO ::: "+despesa.isPago());
				despesas.add(despesa);
				
				if(despesa.isPago()){
					despesaspagas = despesaspagas.add(despesa.getValordespesa());
				}else{
					despesaspendentes = despesaspendentes.add(despesa.getValordespesa());
				}
				
				total = total.add(despesa.getValordespesa());
				
			}
		}
		geral.setDespesaspendentes(Moeda.mascaraDinheiro(despesaspendentes, Moeda.DINHEIRO_REAL));
		geral.setDespesaspagas(Moeda.mascaraDinheiro(despesaspagas, Moeda.DINHEIRO_REAL));
		geral.setTotal(Moeda.mascaraDinheiro(total, Moeda.DINHEIRO_REAL));
		geral.setListadespesas(despesas);
		System.out.println("geral ::::::::: "+geral);
		return geral;
	}
	

	private Map<Long, Despesa> retornaMapDespesas(List<Despesa> listaDespesasFixas) {
		Map<Long, Despesa> mapRetorno = new HashMap<>();
		
		if(listaDespesasFixas != null && listaDespesasFixas.size() > BigInteger.ZERO.intValue()){
			for(Despesa de:listaDespesasFixas){
				if(de.getIddespesapai() == null){
					mapRetorno.put(de.getIddespesa(), de);
					System.out.println("VAI ADD NO MAP 1 :::::: "+de.getIddespesa());
				}else{
					mapRetorno.put(de.getIddespesapai(), de);
					System.out.println("VAI ADD NO MAP :::::: "+de.getIddespesapai());
				}
			}
		}
		
		return mapRetorno;
	}

	public void salvar(Despesa despesa, String usuario) {
		despesa = this.validarDados(despesa);
		
		System.out.println("VALOR DO ID DESPESA AO SALVAR "+despesa.getIddespesa());
		
		UsuarioEntity usuarioLogado = usuarioRepository.findByUsuario(usuario);
		
		DespesaEntity despesaEntity = toDespesaEntity(despesa);
		despesaEntity.setUsuario(usuarioLogado);
		
		this.despesas.save(despesaEntity);
	}
	
	private Despesa validarDados(Despesa despesa) {
		if(despesa != null && !despesa.isRepetir()){
			despesa.setQtd(BigInteger.ZERO.intValue());
			despesa.setPeriodo(Constantes.VAR_VAZIO);
		}		
		
		return despesa;
	}

	public String salvarFoto(Long codigo, MultipartFile foto) {
//		String nomeFoto = fotoStorage.salvar(foto);
//		
//		DespesaEntity despesa = despesas.findOne(codigo);
////		despesa.setFoto(nomeFoto);
//		despesas.save(despesa);
		
//		return fotoStorage.getUrl(nomeFoto);
		return "";
	}
	
	private Despesa toDespesaDTO(DespesaEntity despesaEntity){
		Despesa despesa = new Despesa();
		
		if(despesaEntity != null){
			Categoria categ = new Categoria();
			Conta conta = new Conta();
			
			SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
			
			categ.setIdcategoria(despesaEntity.getCategoria().getIdcategoria()); 
			categ.setNomecategoria(despesaEntity.getCategoria().getNomecategoria());
			categ.setDescricao(despesaEntity.getCategoria().getDescricao());
			
			conta.setDescricao(despesaEntity.getConta().getDescricao());
			conta.setIdConta(despesaEntity.getConta().getIdconta());
			conta.setNomeConta(despesaEntity.getConta().getNomeconta());
			conta.setSaldo(despesaEntity.getConta().getSaldo());
			
			despesa.setCategoria(categ);
			despesa.setConta(conta);
		
			despesa.setDatadespesa(format.format(despesaEntity.getDatadespesa()));
			despesa.setDescricao(despesaEntity.getDescricao());
			despesa.setIddespesa(despesaEntity.getIddespesa());
			despesa.setObservacao(despesaEntity.getObservacao());
			despesa.setValordespesa(despesaEntity.getValordespesa());
			despesa.setValordespesaformatado(Moeda.mascaraDinheiro(despesaEntity.getValordespesa(), Moeda.DINHEIRO_REAL));
			despesa.setQtd(despesaEntity.getQtd());
			despesa.setRepetir(despesaEntity.isRepetir());
			despesa.setFixa(despesaEntity.isFixa());
			despesa.setPeriodo(despesaEntity.getPeriodo());
			despesa.setPago(despesaEntity.isPago());
		}
		
		return despesa;
	}
	
	private DespesaEntity toDespesaEntity(Despesa despesa){
		DespesaEntity despesaEntity = new DespesaEntity();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(despesa != null) {
			CategoriaEntity categ = new CategoriaEntity();
			ContaEntity conta = new ContaEntity();
			
			categ.setIdcategoria(despesa.getCategoria().getIdcategoria()); 
			categ.setNomecategoria(despesa.getCategoria().getNomecategoria());
			categ.setDescricao(despesa.getCategoria().getDescricao());
			
			conta.setDescricao(despesa.getConta().getDescricao());
			conta.setIdconta(despesa.getConta().getIdConta());
			conta.setNomeconta(despesa.getConta().getNomeConta());
			conta.setSaldo(despesa.getConta().getSaldo());
			
			despesaEntity.setCategoria(categ);
			despesaEntity.setConta(conta);
			if(despesa.getDatadespesa() != null){
				try {
					despesaEntity.setDatadespesa(format.parse(despesa.getDatadespesa()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				despesaEntity.setDatadespesa(null);
			}
			/**Editando despesa fixa, quando salvar, ira gravar no banco a despesa*/
			if(despesa.isFixa() && null != despesa.getIddespesa() 
					&& despesa.getIddespesa() != despesa.getIddespesapai()){
				despesaEntity.setIddespesa(null);
			}
			
			despesaEntity.setDescricao(despesa.getDescricao());
			despesaEntity.setIddespesa(despesa.getIddespesa());
			despesaEntity.setObservacao(despesa.getObservacao());
			despesaEntity.setValordespesa(despesa.getValordespesa());
			despesaEntity.setQtd(despesa.getQtd());
			despesaEntity.setRepetir(despesa.isRepetir());
			despesaEntity.setFixa(despesa.isFixa());
			despesaEntity.setPeriodo(despesa.getPeriodo());
			despesaEntity.setPago(despesa.isPago());
		}
		
		return despesaEntity;
	}

	public Despesa buscarPorID(Long iddespesa) {
		Despesa despesa = new Despesa();
		
		if(iddespesa != null){
			despesa = toDespesaDTO(despesas.findOne(iddespesa));
		}
		
		return despesa;
	}
	
	public void deletarDespesa(Long iddespesa){
		if(iddespesa != null){
			DespesaEntity despesaEntity = new DespesaEntity();
			
			despesaEntity = despesas.findOne(iddespesa);
			
			if(despesaEntity != null && despesaEntity.getIddespesa() != null){
				despesas.delete(despesaEntity);
			}
			
		}
		
	}
	
}
