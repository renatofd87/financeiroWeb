package com.financeiro.util;

public class Constantes {
	
	/**URLs*/
	public  static final String URL_AMAZON						= "http://localhost:9444/s3";
	public  static final String URL_LOGIN                		= "/login";
	public  static final String URL_LOGIN_ERRO                	= "/login?error";
	public  static final String URL_DESPESA_RESTRITA 			= "/despesas/**";
	public  static final String URL_LOGOUT                		= "/logout";
	public  static final String URL_IGNORE_LAYOUT               = "/layout/**";
	public  static final String URL_403                			= "/403";
	public  static final String URL_404                			= "/404";
	public  static final String URL_500                			= "/500";
	public  static final String URL_DESPESA_NOVO                = "/despesa/novo";
	public  static final String URL_DESPESA                		= "/despesa";
	public  static final String URL_LISTAGEM_DESPESA 			= "/despesa/ListagemDespesas";
	public  static final String URL_NOVO 						= "/novo";
	public  static final String URL_CADASTRO_DESPESA 			= "/despesa/CadastroDespesa";
	public  static final String URL_REDIRECT_DESPESA_NOVO 		= "redirect:/despesa/novo";
	public  static final String URL_ERRO_404                	= "/error/404";
	public  static final String URL_ERRO_403                	= "/error/403";
	public  static final String URL_ERRO_500                	= "/error/500";
	public  static final String URL_FOTOS                		= "/fotos";
	public  static final String URL_COMPLETA_FOTOS              = "http://localhost:8080/fotos/";
	public  static final String URL_COMPLETA_FOTOS_S3           = "http://localhost:9444/s3/wine/";
	
	/**Diretorios*/
	public  static final String DIRETORIO_LOCALES_MESSAGES      = "locale/messages";
	
	/**Caracteres*/
	public  static final String CARACTER_BARRA                	= "/";
	
	/**Variaveis*/
	public  static final String VAR_DESPESAS                	  = "despesas";
	public  static final String VAR_CATEGORIAS                	  = "categorias";
	public  static final String VAR_CONTAS 						  = "contas";
	public  static final String VAR_DESPESA 					  = "despesa";
	public  static final String VAR_MENSAGEM 					  = "mensagem";
	public  static final String VAR_CODIGO 					  	  = "codigo";
	public  static final String VAR_ARRAY_FILES 				  = "files[]";
	public  static final String VAR_NOME_ALL 				  	  = "/{nome:.*}";
	public  static final String VAR_LOGIN				  	  	  = "Login";
	public  static final String VAR_CATEGORIA                	  = "categoria";
	public  static final String VAR_CONTA                	  	  = "conta";
	public  static final String VAR_VALORDESPESA                  = "valordespesa";
	public  static final String VAR_VALORDESPESA_ZERADO           = "0.00";
	public  static final String VAR_PERIODOS 					  = "periodos";
	public  static final String VAR_VAZIO                		  = "";
	
	/**Parâmetros do Sistema*/
	public  static final String PARAM_CODIGO 					  = "/{codigo}";
	public  static final String PARAM_USER_DETAIL_SERVICE		  = "userDetailsService";
	public  static final String PARAM_NOME_PROJETO_S3			  = "wine";
	public  static final String PARAM_URL_COMPLETA_FOTOS_S3       = "?noAuth=true";
	public  static final String PARAM_LOCALE_PT           		  = "pt";
	public  static final String PARAM_LOCALE_BR           		  = "BR";
	
	/**Mensagens Sucesso*/
	public  static final String MSG_SUCESSO_DESPESA_SALVAR 		  = "Despesa salva com sucesso!";
	
	/**Mensagens Erro*/
	public  static final String MSG_ERRO_NOME_VAZIO 	  		  = "O Campo Nome não foi Preenchido";
	public  static final String MSG_ERRO_SALDO_VAZIO 	  	  	  = "O Campo Saldo não foi Preenchido";
	public  static final String MSG_ERRO_DATA_VAZIO 	  	  	  = "O Campo Data não foi Preenchido";
	public  static final String MSG_ERRO_DESCRICAO_VAZIO 	  	  = "O Campo Descricao não foi Preenchido";
	public  static final String MSG_ERRO_VALOR_VAZIO 	  	  	  = "O Campo Valor não foi Preenchido";
	public  static final String MSG_ERRO_USUARIO_VAZIO 	  	  	  = "O Campo Usuário não foi Preenchido";
	public  static final String MSG_ERRO_SENHA_VAZIO 	  	  	  = "O Campo Senha não foi Preenchido";
	public  static final String MSG_ERRO_SALVAR_PASTA_FOTO 	  	  = "Erro criando pasta para salvar foto";
	public  static final String MSG_ERRO_SALVAR_FOTO 	  	      = "Erro salvando a foto";
	public  static final String MSG_ERRO_RECUPERAR_FOTO 	  	  = "Erro recuperando a foto";
	public  static final String MSG_ERRO_SALVAR_FOTO_S3 	  	  = "Erro salvando arquivo no S3";
	public  static final String MSG_ERRO_TIPO_CONTA 	  		  = "O Tipo da Conta não foi Preenchido";
	
	/*Mensagens Properties pt_BR*/
	public  static final String MSG_PROPERTIE_DESPESA_CATEGORIA_VAZIO	= "despesa.categoria.vazio";
	public  static final String MSG_PROPERTIE_DESPESA_CONTA_VAZIO 	  	= "despesa.conta.vazio";
	public  static final String MSG_PROPERTIE_DESPESA_VALOR_VAZIO 	  	= "despesa.valor.vazio";
	public  static final String MSG_PROPERTIE_CONTA_SALDO_VAZIO 	  	= "conta.saldo.vazio";
	;
	
	/**Tabelas do Sistema*/
	public  static final String TABLE_CATEGORIAS 	  	  	  	  = "categorias";
	public  static final String TABLE_CONTAS 	  	  	  	  	  = "contas";
	public  static final String TABLE_DESPESAS 	  	  	  	  	  = "despesas";
	public  static final String TABLE_DESPESAS_FIXAS 	  	  	  = "despesasfixas";
	public  static final String TABLE_USUARIOS	  	  	  	  	  = "usuarios";
	public  static final String TABLE_USUARIO_ROLES	  	  	  	  = "usuarioroles";
	public  static final String TABLE_TIPO_CONTA	  	  	  	  = "tipoconta";
	
	/**Colunas Tabelas*/
	public  static final String COLUNA_IDCONTA 	  	  	  	  	  = "idconta";
	public  static final String COLUNA_IDCATEGORIA 	  	  	  	  = "idcategoria";
	public  static final String COLUNA_ROLE 	  	  	  	  	  = "role";
	public  static final String COLUNA_USER_ROLE_ID 	  	  	  = "user_role_id";
	public  static final String COLUNA_IDUSUARIOROLE 	  	  	  = "idusuariorole";
	public  static final String NOME_COLUNA_TIPO_CONTA            = "tipoconta";
	public  static final String NOME_COLUNA_ID_TIPO_CONTA         = "idtipoconta";
	public  static final String NOME_COLUNA_DATA_CRIACAO          = "datacriacao";
	
	/**Configurações do Sistema*/
	public  static final String CONFIG_DATA_DIA_MES_ANO 	  	  = "dd/MM/yyyy";
	public  static final String CONFIG_DATA_ANO_MES_DIA 	  	  = "yyyy/MM/dd";
	
	/**Profiles*/
	public  static final String PROFILE_STORAGE_LOCAL 	  	  	  = "storage-local";
	public  static final String PROFILE_STORAGE_S3 	  	  	      = "storage-s3";
	
	/**AmazonConfig*/
	public  static final String BASIC_AWS_CREDENTIALS 			= "AKIAIOSFODNN7EXAMPLE";
	public  static final String BASIC_AWS_CREDENTIALS_2 		= "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
	
	
	/**SecurityConfig*/
	public  static final String ROLES_PERMITIDAS                = "hasRole('CADASTRAR_DESPESA')";
	public  static final String PARAM_USERNAME                	= "username";
	public  static final String PARAM_PASSWORD                	= "password";
	
	
	/**WebConfig*/
	public  static final String ENCODING        				= "ISO-8859-1";
	
	/**FotoStorageLocal*/
	public  static final String DIRETORIO_SALVAR_LOCAL        	= "HOME";
	public  static final String PASTA_SALVAR_LOCAL        	    = ".winefotos";
	
	/**Moeda*/
	public  static final String FORMAT_MOEDA_DECIMAL       	    = "¤ ###,###,##0.00";
	
}
