package com.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financeiro.entities.DespesaEntity;

public interface DespesasRepository extends JpaRepository<DespesaEntity, Long> {
	@Query("select d from DespesaEntity d order by d.datadespesa ")
	List<DespesaEntity> findAllOrderBydatadespesa();	
	
	@Query(nativeQuery = true, value="(select * from despesas d where Month(d.datadespesa) = :mes and Year(d.datadespesa) = :ano and idusuario = :idusuario)"
				
		   ) 
	List<DespesaEntity> buscarDespesasPorMesAno(@Param("mes") Long mes, @Param("ano") Long ano, 
			@Param("idusuario") Long idusuario);
}


 

