public class Executora {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(16);
        arvoreBinaria.inserir(13);

        System.out.println("Pos Ordem:");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        System.out.println("----------------------------------");
        arvoreBinaria.remover(10);
        System.out.println("Pos Ordem:");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
    }
}
