import java.util.ArrayList;
import java.util.Scanner;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    //Metodo de adicao de veiculo
    public boolean addVeiculo(Veiculo novo_veiculo) {
        for (Veiculo veiculo:listaVeiculos) {
            if (veiculo.equals(novo_veiculo))
                return false;
        }
        listaVeiculos.add(novo_veiculo);
        System.out.println("Veiculo " + novo_veiculo.getMarca() + " " + novo_veiculo.getModelo() + " (placa " + novo_veiculo.getPlaca()  + ") adicionado com sucesso!\n");
        return true;
    }

    //Metodo de remocao de veiculo
    public boolean removeVeiculo(Scanner scanner) {
        System.out.println("Selecione um veiculo: ");
        int i = 1;
        for (Veiculo veiculo:listaVeiculos) {
            System.out.println(i + " - " + veiculo.getModelo() + "(placa " + veiculo.getPlaca() + ")");
            i++;
        }
        int j = scanner.nextInt();
        System.out.println("Veiculo " + listaVeiculos.get(j-1).getMarca() + " " + listaVeiculos.get(j-1).getModelo() + " (placa " + listaVeiculos.get(j-1).getPlaca()  + ") removido com sucesso!\n");
        listaVeiculos.remove(listaVeiculos.get(j-1));
        return true;
    }

    //Metodo toString de Frota para imprimir
    public String toString() {
        String str = "Dados da frota\nCode: " + code + "\nLista de veiculos:\n";
        for (int i = 0; i < listaVeiculos.size(); i++) {
            str = str + listaVeiculos.get(i).getMarca() + " " + listaVeiculos.get(i).getModelo() + " (placa " +
                listaVeiculos.get(i).getPlaca() + ") |\n";
        }
        str = str + "\n";
        return str;
    }
}