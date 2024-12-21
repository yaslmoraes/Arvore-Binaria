public class ArvoreBinaria {
    private No raiz;


    private int remover;


    public ArvoreBinaria() {
        this.raiz = null;
    }


    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        if (raiz == null) {
            //System.out.println("A raiz foi criada com o conteúdo " + novoNo.getConteudo() + ".");
            raiz = novoNo;
        } else {
            //Verificar se ficara a esq ou direita
            No atual = raiz;
            while (true) {
                No pai = atual;
                if (novoNo.getConteudo() <= atual.getConteudo()) {
                    //posicionar o nó à esq
                    atual = atual.getEsquerda();
                    if (atual == null) {
                        pai.setEsquerda(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                } else {
                    //posicionar o nó à dir
                    atual = atual.getDireita();
                    if (atual == null) {
                        pai.setDireita(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                }
            }
        }
    }


    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }


    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }


    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }


    public No getRaiz() {
        return raiz;
    }

    //Recebe o valor a ser removido
    public void remover(int valor) {
        //A a arvore recebe o nova arvore sem o no removido
        raiz = removerNo(raiz, valor);
    }

    private No removerNo(No no, int valor) {
        //Raiz nula
        if (no == null) {
            System.out.println("O arvore esta vazia.");
            return null;
        }

        No pai = null;
        No atual = no;

        // Busca (se não chegamos ao final da arvore e o valor do no atual não for o que estamos buscando, percorre a arvore)
        while (atual != null && atual.getConteudo() != valor) {
            pai = atual;
            if (valor < atual.getConteudo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        // Chegou ao fim da arvore e o No não foi encontrado
        if (atual == null) {
            System.out.println("O no não pertence a arvore.");
            return no;
        }

        //Remoção se for um No folha
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            if (atual != no) {
                if (pai.getEsquerda() == atual) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
            } else {
                no = null;
            }
        }

        //Remoção se for um No com apenas um filho a direita
        else if ((atual.getEsquerda() == null) && (atual.getDireita() != null)) {
            if (atual != no) {
                if (pai.getEsquerda() == atual) {
                    pai.setEsquerda(atual.getDireita());
                } else {
                    pai.setDireita(atual.getDireita());
                }
            } else {
                no = atual.getDireita();
            }
        }

        //Remoção se for um No com apenas um filho a esquerda
        else if ((atual.getEsquerda() != null) && (atual.getDireita() == null)) {
            if (atual != no) {
                if (pai.getEsquerda() == atual) {
                    pai.setEsquerda(atual.getEsquerda());
                } else {
                    pai.setDireita(atual.getEsquerda());
                }
            } else {
                no = atual.getEsquerda();
            }
        }

        //Remoção se for um No com dois filhos
        else {
            No sucessor = encontrarSucessor(atual.getDireita());
            atual.setConteudo(sucessor.getConteudo());
            atual.setDireita(removerNo(atual.getDireita(), sucessor.getConteudo()));
        }

        //Removeu raiz sem filhos
        if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
            raiz = null;
            System.out.println("A árvore ficou vazia.");
        }

        return no;
    }

    private No encontrarSucessor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}
