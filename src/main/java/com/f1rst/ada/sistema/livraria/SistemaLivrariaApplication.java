package com.f1rst.ada.sistema.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SistemaLivrariaApplication  {

//	implements CommandLineRunner
//	@Autowired
//	private ClientesRepository clientesRepository;
	public static void main(String[] args) {
		SpringApplication.run(SistemaLivrariaApplication.class, args);
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		SpringApplication.run(SistemaLivrariaApplication.class, args);
//		ClientesEntity 	clientesEntity = new ClientesEntity();
//		clientesEntity.setIdClientes(1);
//		clientesEntity.setNome("Samila");
//		clientesEntity.setRg("0000-1X");
//		clientesEntity.setCpf("000.000.000-00");
////		clientesEntity.setIdade(18);
//		clientesRepository.save(clientesEntity);
//	ClientesEntity 	clientesEntity2 = new ClientesEntity();
//		clientesEntity2.setIdClientes(2);
//		clientesEntity2.setNome("Lucas");
//		clientesEntity2.setRg("0000-1X");
//		clientesEntity2.setCpf("000.000.000-00");
////		clientesEntity2.setIdade(30);
//		clientesRepository.save(clientesEntity2);
//	ClientesEntity 	clientesEntity3 = new ClientesEntity();
//		clientesEntity3.setIdClientes(3);
//		clientesEntity3.setNome("Camila");
//		clientesEntity3.setRg("0000-1X");
//		clientesEntity3.setCpf("000.000.000-00");
////		clientesEntity3.setIdade(25);
//		clientesRepository.save(clientesEntity3);
//		
//		
//	}

}
