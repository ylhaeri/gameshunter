//package br.com.gameshunter.factory;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.gameshunter.model.Endereco;
//import br.com.gameshunter.model.Sexo;
//import br.com.gameshunter.model.Usuario;
//
//public class UsuarioFactory {
//
//	/**
//	 * Método para criar um usuário repetido.
//	 * 
//	 * @return Endereço
//	 */
//	public Usuario repetidoSemEnderecos() {
//		List<Endereco> enderecos = new ArrayList<>();
//		return new Usuario("ronaldoplosra@hotmail.com", "Ronaldo Plosra Silva",
//				"Rosnaldin", "senhadoronaldo", Sexo.Masculino,
//				"111.111.111-11", LocalDate.of(1990, 01, 01), enderecos,
//				"(11) 1111-1111");
//	}
//
//	/**
//	 * Método para criar um usuário com e-mail único.
//	 * 
//	 * @return Endereço
//	 */
//	public Usuario comEmailSemEndereco(String email) {
//		List<Endereco> enderecos = new ArrayList<>();
//		return new Usuario(email, "Ronaldo Plosra Silva", "Rosnaldin",
//				"senhadoronaldo", Sexo.Masculino, "111.111.111-11",
//				LocalDate.of(1990, 01, 01), enderecos, "(11) 1111-1111");
//	}
//
//	/**
//	 * Método para criar um usuário repetido com endereços.
//	 * 
//	 * @return Endereço
//	 */
//	public Usuario repetidoComEnderecos() {
//		List<Endereco> enderecos = new ArrayList<>();
//		enderecos.add(new EnderecoFactory().comLogradouro("Rua Sergipe"));
//		enderecos.add(new EnderecoFactory().comLogradouro("Rua Guadalupe"));
//		enderecos.add(new EnderecoFactory().comLogradouro("Avenida Muranha"));
//		return new Usuario("ronaldoplosra@hotmail.com", "Ronaldo Plosra Silva",
//				"Rosnaldin", "senhadoronaldo", Sexo.Masculino,
//				"111.111.111-11", LocalDate.of(1990, 01, 01), enderecos,
//				"(11) 1111-1111");
//	}
//
//	/**
//	 * Método para criar um usuário com e-mail único e com endereços.
//	 * 
//	 * @return Endereço
//	 */
//	public Usuario comEmailEEnderecos(String email) {
//		List<Endereco> enderecos = new ArrayList<>();
//		enderecos.add(new EnderecoFactory().comLogradouro("Rua Sergipe"));
//		enderecos.add(new EnderecoFactory().comLogradouro("Rua Guadalupe"));
//		enderecos.add(new EnderecoFactory().comLogradouro("Avenida Muranha"));
//		return new Usuario(email, "Ronaldo Plosra Silva", "Rosnaldin",
//				"senhadoronaldo", Sexo.Masculino, "111.111.111-11",
//				LocalDate.of(1990, 01, 01), enderecos, "(11) 1111-1111");
//	}
//
//	/**
//	 * Compara 2 usuários.
//	 * 
//	 * @param primeiro
//	 * @param segundo
//	 * 
//	 * @return verdadeiro ou falso.
//	 */
//	public boolean saoIguais(Usuario primeiro, Usuario segundo) {
//
//		if (primeiro.getApelido().equals(segundo.getApelido())
//				&& primeiro.getCpf().equals(segundo.getCpf())
//				&& primeiro.getEmail().equals(segundo.getEmail())
//				&& primeiro.getEnderecos().equals(segundo.getEnderecos())
//				&& primeiro.getNome().equals(segundo.getNome())
//				&& primeiro.getSenha().equals(segundo.getSenha())
//				&& primeiro.getSexo().equals(segundo.getSexo())
//				&& primeiro.getTelefone().equals(segundo.getTelefone()))
//			return true;
//		else
//			return false;
//	}
//}