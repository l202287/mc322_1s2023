public class Validacao {
    
    //Funçoes para validar o CPF
    static public String CPFpadrao(String cpf) {
    	
        //Deixar numeros apenas no Cpf 
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    static public int calculaDigitoVerificadorCPF(int n, String cpf) {
    	
        //Calculo para os digitos verificadores
        int digito;
        int soma = 0;
        int cont = n + 1;
        for (int i = 0; i < n; i++) {
            soma = soma + (Character.getNumericValue(cpf.charAt(i)))*cont;
            cont--;
        }
        int resto = soma % 11;
        if (resto == 0 || resto == 1)
            digito = 0;
        else 
            digito = 11 - resto; 
        return digito;
    }

    static public Boolean validarCPF(String cpf) {
    	
        //CPF valido retorna true. Caso nao retorna false
        cpf = CPFpadrao(cpf);

        //Verifica se tem 11 numeros
        if (cpf.length() != 11) 
            return false;
            
        //Verifica se todos os numeros são identicos
        int somaaux = 0; 
        for (int i = 1; i < cpf.length(); i++) { 
            if (cpf.charAt(i) == cpf.charAt(0)) 
                somaaux++;
        }
        if (somaaux == 10) 
            return false;
        
        //Verifica se os digitos verficadores sao validos com o esperado
        int digito1Esperado = Character.getNumericValue(cpf.charAt(9)); //Penultimo numero do CPF
        int digito2Esperado = Character.getNumericValue(cpf.charAt(10)); //Ultimo numero do CPF
        int digito1 = calculaDigitoVerificadorCPF(9, cpf); 
        int digito2 = calculaDigitoVerificadorCPF(10, cpf);      
        if (digito1 != digito1Esperado || digito2 != digito2Esperado) 
            return false;

        return true; //retorna true, caso nenhuma das condicoes retornou false
    }

    //Funçoes para validar o CNPJ
    static public String deixaCNPJarrumado(String cnpj) {
    	
        //Deixar numeros apenas no CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
        return cnpj;
    }

    static public int calculaDigitoVerificadorCNPJ(int n, String cnpj) { 
    	
        //Calculo dos digitos verificadores
        int digito;
        int soma = 0;
        int cont = n - 7;
        for (int i = 0; i < n; i++) {
            soma = soma + (Character.getNumericValue(cnpj.charAt(i)))*cont;
            cont--;
            if (cont == 1)
                cont = 9;
        }
        int resto = soma % 11;
        if (resto == 0 || resto == 1)
            digito = 0;
        else 
            digito = 11 - resto; 
        return digito;
    }

    static public Boolean validarCNPJ(String cnpj) {
        //CNPJ válido retorna true. Caso nao retorna false
        cnpj = deixaCNPJarrumado(cnpj);

        //Verifica se tem 14 numeros
        if (cnpj.length() != 14) 
            return false;

        //Verifica se todos os numeros sao identicos
        int somaaux = 0; 
        for (int i = 1; i < cnpj.length(); i++) { 
            if (cnpj.charAt(i) == cnpj.charAt(0)) 
                somaaux++;
        }
        if (somaaux == 13) 
            return false;
        
        //Verifica se os digitos verficadores sao validos com os esperados
        int digito1Esperado = Character.getNumericValue(cnpj.charAt(12)); //Penultimo numero do CNPJ
        int digito2Esperado = Character.getNumericValue(cnpj.charAt(13)); //Ultimo numero do CNPJ
        int digito1 = calculaDigitoVerificadorCNPJ(12, cnpj); 
        int digito2 = calculaDigitoVerificadorCNPJ(13, cnpj);      
        if (digito1 != digito1Esperado || digito2 != digito2Esperado) 
            return false;

        return true; //retorna true, caso nenhuma das condicoes retornou false
    }

    //Funçao para validar do nome do cliente
    static public boolean validarNome(String nome) {
        boolean a = nome.matches("^[ A-Za-z]+$");
        return a;
    }

}