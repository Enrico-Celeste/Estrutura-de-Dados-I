public class ArvoreAVL {
    private Banco b;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int bal;

    public ArvoreAVL(){
        this.b = null;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
    }
    
    public ArvoreAVL(Banco num){
        this.b = num;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
    }

    //Metodos
    public boolean isEmpty(){
        return (this.b == null);
    }

    public ArvoreAVL inserir(Banco novo){
        if(isEmpty())
            this.b = novo;
        else{
            ArvoreAVL novaArvoreAVL = new ArvoreAVL(novo);
            if(novo.getNumero() < this.b.getNumero()){
                if(this.esq == null)
                    this.esq = novaArvoreAVL;
                else
                    this.esq = this.esq.inserir(novo);
            }
            else if(novo.getNumero() > this.b.getNumero()){
                if(this.dir == null)
                    this.dir = novaArvoreAVL;
                else
                    this.dir = this.dir.inserir(novo);
            }
        }
        return this;
    }

    public ArvoreAVL remover(Banco num){
        if(this.b.getNumero() == num.getNumero()){
            if(this.dir == null && this.esq == null)//sem filhos
                return null;
            else{
                if(this.esq != null &&  this.dir == null)//filhos a esquerda apenas
                    return this.esq;
                else if(this.dir != null &&  this.esq == null)//filhos a direita apenas
                    return this.dir;
                else{//filhos a direita e a esquerda
                    ArvoreAVL aux = this.esq;
                    while(aux.dir != null)
                        aux = aux.dir;
                    this.b = aux.getBanco();
                    aux.setBanco(num);
                    this.esq = esq.remover(num);
                }
            }
        }
        else if(num.getNumero() < this.b.getNumero()){
            this.esq = this.esq.remover(num);
        }
        else if(num.getNumero() > this.b.getNumero()){
            this.dir = this.dir.remover(num);
        }
        return this;
    }

    public boolean busca(int numero){
        if(isEmpty())
            return false;
        if(this.b.getNumero() == numero)
            return true;
        else{
            if(numero < this.b.getNumero()){
                if(this.esq == null)
                    return false;
                else
                    return this.esq.busca(numero);
            }
            else if(numero > this.b.getNumero()){
                if(this.dir == null)
                    return false;
                else
                    return this.dir.busca(numero);
            }
            return false;
        }
    }

    public String imprimirArvore(int posicao){
        String str = "{"+ this.b.getNumero() +"} (" + this.bal + ")\n";
        for(int i = 0; i < posicao; i++)
            str += "\t";
        if(this.esq != null)
            str += "+-ESQ: " + this.esq.imprimirArvore(posicao + 1);
        else
            str += "+-ESQ: NULL";
        str += "\n";
        for(int i = 0; i < posicao; i++)
            str += "\t";
        if(this.dir != null)
            str += "+-DIR: " + this.dir.imprimirArvore(posicao + 1);
        else
            str += "+-DIR: NULL";
        str += "\n";
        return str;
    }

    public int calculoAltura(){
        if(this.esq == null && this.dir == null) //arvore sem filhos
            return 1;
        else if(this.esq != null && this.dir == null) //filhos apenas na esquerda
            return 1+esq.calculoAltura();
        else if(this.esq == null && this.dir != null) //filhos apenas na direita
            return 1+dir.calculoAltura();
        else //filhos dos dois lados
            return 1+ Math.max(this.esq.calculoAltura(), this.dir.calculoAltura()); 
    }

    public void calculoBalanceamento(){
        if(this.esq == null && this.dir == null) //arvore sem filhos
            this.bal = 0;
            else if(this.esq != null && this.dir == null) //filhos apenas na esquerda
                this.bal = 0 - this.esq.calculoAltura();
            else if(this.esq == null && this.dir != null) //filhos apenas na direita
                this.bal = this.dir.calculoAltura() - 0;
            else //filhos dos dois lados
                this.bal = this.dir.calculoAltura() - this.esq.calculoAltura();
            if(this.esq != null)
                this.esq.calculoBalanceamento();
            if(this.dir != null)
                this.dir.calculoBalanceamento();
    }

    public ArvoreAVL verificaBalanceamento(){
        if(this.bal >= 2 || this.bal <= -2){
            if(this.bal >= 2){
                if(this.bal * this.dir.getBal() > 0)
                    return rotacaoSimplesDireita();
                else
                    return rotacaoDuplaDireita();
            }
            else{
                if(this.bal * this.esq.getBal() > 0)
                    return rotacaoSimplesEsquerda();
                else
                    return rotacaoDuplaEsquerda();
            }
        }
        this.calculoBalanceamento();
        if(this.esq != null)
            this.esq = this.esq.verificaBalanceamento();
        if(this.dir != null)
            this.dir = this.dir.verificaBalanceamento();
        return this;
    }

    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoFil = null;

        filhoDir = this.getDir();
        if(this.dir != null){
            if(this.dir.getEsq() != null){
                filhoFil = filhoDir.getEsq();
            }
        }
        filhoDir.setEsq(this);
        this.setDir(filhoFil);
        return filhoDir;
    }

    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore = this;
        ArvoreAVL filhoDir = this.getDir();
        ArvoreAVL filhoFil = filhoDir.getEsq();
        ArvoreAVL filhoFilFil = filhoFil.getDir();

        //Alinhar
        filhoDir.setEsq(filhoFilFil);
        filhoFil.setDir(filhoDir);
        this.setDir(filhoFil);

        //tornar filho a direita nova raiz
        ArvoreAVL novoFilhoDireita = this.getDir();
        arvore.setDir(null);
        novoFilhoDireita.setEsq(arvore);
        return novoFilhoDireita;
    }

    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoFil = null;

        filhoEsq = this.getEsq();
        if(this.esq != null){
            if(this.esq.getDir() != null){
                filhoFil = filhoEsq.getDir();
            }
        }
        filhoEsq.setDir(this);
        this.setEsq(filhoFil);
        return filhoEsq;
    }

    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore = this;
        ArvoreAVL filhoEsq = this.getEsq();
        ArvoreAVL filhoFil = filhoEsq.getDir();
        ArvoreAVL filhoFilFil = filhoFil.getEsq();

        //Alinhar
        filhoEsq.setDir(filhoFilFil);
        filhoFil.setEsq(filhoEsq);
        this.setEsq(filhoFil);

        //tornar filho a esquerda nova raiz
        ArvoreAVL novoFilhoEsquerda = this.getEsq();
        arvore.setEsq(null);
        novoFilhoEsquerda.setDir(arvore);
        return novoFilhoEsquerda;
    }

    //Gets Sets
    public void setBanco(Banco b){
        this.b = b;
    }
    public void setDir(ArvoreAVL dir){
        this.dir = dir;
    }
    public void setEsq(ArvoreAVL esq){
        this.esq = esq;
    }
    public void setBal(int bal){
        this.bal = bal;
    }

    public Banco getBanco(){
        return this.b;
    }
    public ArvoreAVL getDir(){
        return this.dir;
    }
    public ArvoreAVL getEsq(){
        return this.esq;
    }
    public int getBal(){
        return this.bal;
    }
}