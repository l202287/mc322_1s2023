
public class Validacao {
	public static boolean validarCPF(String cpf) {
		
		//Deixar aenas numeors e ver se tem 11 digitos
		String cpfAuxiliar = cpf.replaceAll("[^0-9]+", "");

		if (cpfAuxiliar.length() != 11){
			return false;
		}
		
		int contRep = 0;
		//Percorrer cpf pra ver se todos digitos sao iguais
		for (int i = 0; i < 10; i++) {
			if (cpfAuxiliar.charAt(i) == cpfAuxiliar.charAt(i + 1)) {
				contRep += 1;
			}
		}
		if (contRep == 10) { 
			return false;
		}
		
		int verificadorPrimeiroDigitoCPF = Character.getNumericValue(cpfAuxiliar.charAt(9)); //penultimo numero do cpf
		int verificadorSegundoDigitoCPF = Character.getNumericValue(cpfAuxiliar.charAt(10)); //ultimo numero do cpf
		int somaAtual1 = 0;
		int somaAtual2 = 0;
		
		//Algoritimo para os calculos envolvendo 1 digito de seguranca
		for (int i = 0, j = 10; i < 9; i++, j--) {		
			somaAtual1 += j * Character.getNumericValue(cpfAuxiliar.charAt(i));
		}
		
		if (somaAtual1 % 11 == 0 || somaAtual1 % 11 == 1) {
			if (verificadorPrimeiroDigitoCPF != 0) {
				return false;
			}
		}
		else if (11 - somaAtual1 % 11 != verificadorPrimeiroDigitoCPF) {
			return false;
		}
		
		// Calculos para o 2 digito de seguranca
		for (int i = 1, j = 10; i < 10; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cpfAuxiliar.charAt(i));
		}
		
		if (somaAtual2 % 11 == 0 || somaAtual2 % 11 == 1) {
			if (verificadorSegundoDigitoCPF != 0) {
				return false;
			}
		}
		else if (11 - somaAtual2 % 11 != verificadorSegundoDigitoCPF) {
			return false;
		}
		
		return true;		
	}	
	
	public static boolean validarCNPJ(String cnpj) {
		String cnpjAuxiliar = cnpj.replaceAll("[^0-9]+", "");
		
		int verificadorPrimeiroDigitoCNPJ = Character.getNumericValue(cnpjAuxiliar.charAt(12)); //penultimo digito da cnpj
		int verificadorSegundoDigitoCNPJ = Character.getNumericValue(cnpjAuxiliar.charAt(13)); //ultimo digito da cnpj
		
		//verificar se tem 14 digitos
		if (cnpjAuxiliar.length() != 14)
			return false;
		
		//penultimo digito e valido?
		int somaAtual1 = 0;
		
		for (int i = 0, j = 5; i < 4 ; i++, j--) {
			somaAtual1 += j * Character.getNumericValue(cnpjAuxiliar.charAt(i));
		}
		for (int i = 4, j = 9; i < 12; i++, j--) {
			somaAtual1 += j * Character.getNumericValue(cnpjAuxiliar.charAt(i));
		}
		
		if (somaAtual1 % 11 == 0 || somaAtual1 % 11 == 1) {
			if (verificadorPrimeiroDigitoCNPJ != 0) {
				return false;
			}
			
		}else if (11 - (somaAtual1 % 11) != verificadorPrimeiroDigitoCNPJ) {
			return false;
		}
		
		// ultimo digito e valido?
		int somaAtual2 = 0;
		
		for (int i = 0, j = 6; i < 5; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cnpjAuxiliar.charAt(i));
		}

		for (int i = 5, j = 9; i < 13; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cnpjAuxiliar.charAt(i));
		}
		
		if (somaAtual2 % 11 == 0 || somaAtual2 % 11 == 1) {
			if (verificadorSegundoDigitoCNPJ != 0) {
				return false;
			}
			
		}else if (11 - (somaAtual2 % 11) != verificadorSegundoDigitoCNPJ) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validarNome(String nome) {
		return nome.matches("[a-zA-z]+"); 
		//verificar se tem apenas letras
	}
}
