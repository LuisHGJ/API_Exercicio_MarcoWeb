package app.autenticacao;

public interface UsuarioRepository extends org.springframework.data.jpa.repository.JpaRepository<Usuario, Long> {
    Usuario findByNomeDeUsuario(String nomeDeUsuario);
}