import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe para criar o personagem Gato.
 * 
 * @author (Jhonatan Morais - jhonatanvinicius@gmail.com | jhonatan@dfjug.org) 
 * @version (1.0)
 */
public class Gato extends Actor
{
    public int proximoPasso = 2;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    public static final int ALTURA_MAXIMA_PULO = 15;
    
    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;
    
    

    /**
     * Act - do whatever the Gato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        setImage(new GreenfootImage("personagens/gato/ze_"+proximoPasso+".png"));

        if( possoAtualizar()){
            proximoPasso++;
        }

        if(proximoPasso > 6){
            proximoPasso = 1;
        }
        
        
        if(Greenfoot.isKeyDown("space")){
            
            estaEmTerraFirme = false;
            estaEmPulo = true;
        
        }
        
        executaSubidaDoPulo();
        
        
    }
    
    public void executaSubidaDoPulo(){
        if( alturaAtualDoPulo < ALTURA_MAXIMA_PULO  && estaEmPulo ){
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - Mundo1.FORCA_DE_GRAVIDADE * 2);

        }

    }
    
    
    /**
     * Retorna o valor do limite inferior do personagem
     */
    public int alturaDosPes(){
    
        return  getY() + getImage().getHeight()/2;
    
    }
    
    /**
     * Retorna a altura atual do personagem dentro do jogo
     */
    public int alturaAtual(){ 
    
           return (alturaDosPes() - Mundo1.NIVEL_DO_SOLO) * -1;
    
    
    }  
    
    /**
     * Verifica se a imgem do ator ja pode ser atualizada
     */
    private boolean possoAtualizar(){
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0 ;
    }

    
}
