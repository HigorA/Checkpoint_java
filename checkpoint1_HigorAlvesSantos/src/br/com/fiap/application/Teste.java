package br.com.fiap.application;

import br.com.fiap.model.Acessorio;
import br.com.fiap.model.Veiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Teste {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");

        List<Veiculo> veiculos = new ArrayList<>();
        int count = 0;

        try {
            while(count < 5) {
                System.out.println("*-- Cadastro de Veiculo " + (count + 1) + " --*");
                System.out.println("Modelo");
                String modelo = scanner.nextLine();
                System.out.println("Ano de Fabricaçao");
                Date anoFabricacao = format.parse(scanner.next());
                System.out.println("Valor do Veiculo");
                double valor = scanner.nextDouble();
                System.out.println("Montadora");
                String montadora = scanner.next();
                Veiculo veiculo = new Veiculo(anoFabricacao,modelo,valor,montadora);
                for (int count1 = 0; count1 < 3; count1++) {
                    System.out.println("Deseja cadastrar um acessorio?");
                    String cadastrar = String.valueOf(scanner.next().toUpperCase().charAt(0));
                    if (cadastrar.equals("N")) {
                        break;
                    }
                    System.out.println("Nome do acessorio");
                    String nomeAcessorio = scanner.next();
                    System.out.println("Informe o valor");
                    double preco = scanner.nextDouble();
                    Acessorio acessorio = new Acessorio(nomeAcessorio, preco);
                    veiculo.addAcessorios(acessorio);
                }
                veiculos.add(veiculo);
                System.out.println("Deseja cadastrar um novo veiculo?");
                String continuar = String.valueOf(scanner.next().toUpperCase().charAt(0));
                if (continuar.equals("N")) {
                    break;
                }
                scanner.nextLine();
                count++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Insira um dado valido");
        } catch (NullPointerException e) {
            System.out.println("Elemento nao existe.");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posiçao invalida do array");
        }
        finally {
            scanner.close();
            for (Veiculo veic : veiculos){
                System.out.println(veic);
            }
            System.out.println(countVeic(veiculos));
            System.out.println(mediaVeic(veiculos));
            System.out.println(veicMaisCaro(veiculos));
            System.out.println(countAces(veiculos));
        }
    }

    public static int countVeic(List<Veiculo> veiculos) {
        int count = 0;
        for (Veiculo veic : veiculos) {
            count++;
        }
        return count;
    }

    public static double mediaVeic(List<Veiculo> veiculos) {
        double total = 0;
        for (Veiculo veic : veiculos) {
            total += veic.getValor();
        }
        return total;
    }

    public static Veiculo veicMaisCaro(List<Veiculo> veiculos) {
        Veiculo maisCaro = new Veiculo();
        for (int i = 0; i< veiculos.size() - 1; i++) {
           for (int j = 1; j<veiculos.size(); j++) {
               if (veiculos.get(i).getValor() > veiculos.get(j).getValor()) {
                   maisCaro = veiculos.get(i);
               }
               else {
                   maisCaro = veiculos.get(j);
               }
           }
       }
        return maisCaro;
    }

    public static int countAces(List<Veiculo> veiculos) {
        int count = 0;
        for (Veiculo veic : veiculos) {
            for (int i = 0; i<veic.getAcessorios().size(); i++) {
                count += veic.getAcessorios().get(i).getValor();
            }
        }
        return count;
    }

}

