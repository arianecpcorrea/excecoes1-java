package model.exceptions;

// DomainException = o nome Domain é porque ela vai ser uma Exceção que vai dar na minha entidade de domínio que é
// a classe Reservation, isso é uma convenção, uma preferência, e como é uma Exceção, colocamos
// o sufixo Exception nela

// essa Domain Exception pode ser exceção da Classe Exception ou da RuntimeException, a RuntimeException
// o compilador não obriga vc a tratar, agora se a sua DomainException for uma subClasse de Exception
// o compilador vai obrigar vc a tratar

//OBS.: classes serializable são objetos que podem ser convertidos para variáveis do tipo long,
// para bytes e assim trafegar e serem gravados em arquivos etc, isso é padrão do Java.




public class DomainException extends Exception {
    private static final long serialVersionUID = 1L; //então quando um tipo é serializable ele precisa ter uma versão, então eu vou colocar aqui
    // o valor padrão de versão

    // vou colocar abaixo um Construtor que recebe uma String como argumento, 
    public DomainException(String msg) {
        super(msg);// aqui estou repassando essa mensagem para o construtor da SuperClasse
        // isso foi feito para que eu possa permitir que a minha exceção personalizada (DomainException)
        //receba uma mensagem e essa mensagem fique armazenada dentro da minha exceção
    }
}
