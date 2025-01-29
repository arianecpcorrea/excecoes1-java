package model.exceptions;

// DomainException = o nome Domain é porque ela vai ser uma Exceção que vai dar na minha entidade de domínio que é
// a classe Reservation, isso é uma convenção, uma preferência, e como é uma Exceção, colocamos
// o sufixo Exception nela

// essa Domain Exception pode ser exceção da Classe Exception ou da RuntimeException, a RuntimeException
// o compilador não obriga vc a tratar, agora se a sua DomainException for uma subClasse de Exception
// o compilador vai obrigar vc a tratar

//OBS.: classes serializable são objetos que podem ser convertidos para variáveis do tipo long,
// para bytes e assim trafegar e serem gravados em arquivos etc, isso é padrão do Java.


//AGORA AQUI EMBAIXO EU VOU TIRAR A Exception E VOU COLOCAR A RuntimeException, explicação:

//In Java, there are two types of exceptions: checked exceptions and un-checked exceptions. A checked exception must be handled explicitly by the code, whereas, an un-checked exception does not need to be explicitly handled.

//For checked exceptions, you either have to put a try/catch block around the code that could potentially throw the exception, or add a "throws" clause to the method, to indicate that the method might throw this type of exception (which must be handled in the calling class or above).

//Any exception that derives from "Exception" is a checked exception, whereas a class that derives from RuntimeException is un-checked. RuntimeExceptions do not need to be explicitly handled by the calling code.

//JAVA DOCUMENTATION ABOUT RuntimeException

// Because the Java programming language does not require methods to catch or to specify unchecked 
//exceptions (RuntimeException, Error, and their subclasses), programmers may be tempted to write code
 //that throws only unchecked exceptions or to make all their exception subclasses inherit from 
 //RuntimeException. Both of these shortcuts allow programmers to write code without bothering with 
 //compiler errors and without bothering to specify or catch any exceptions. Although this may seem 
 // convenient to the programmer, it sidesteps the intent of the catch or specify requirement and 
 //can cause problems for others using your classes.


public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1L; //então quando um tipo é serializable ele precisa 
    // ter uma versão, então eu vou colocar aqui o valor padrão de versão

    // vou colocar abaixo um Construtor que recebe uma String como argumento, 
    public DomainException(String msg) {
        super(msg);// aqui estou repassando essa mensagem para o construtor da SuperClasse
        // isso foi feito para que eu possa permitir que a minha exceção personalizada (DomainException)
        //receba uma mensagem e essa mensagem fique armazenada dentro da minha exceção
    }
}
