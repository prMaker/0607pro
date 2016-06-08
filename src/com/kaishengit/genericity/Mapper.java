package com.kaishengit.genericity;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Mapper<T> {

    private T item;
    private Mapper<T> next = new Mapper<T>();

    public void setItem(T items){
        this.item = item;
    }

    public T getItem(){
        return item;
    }

    public void setNext(Mapper<T> next){
        this.next=next;
    }

    public Mapper<T> getNext(){
        return next;
    }

    public void add(T item){
        if(this.getItem()==null){
            this.setItem(item);
        }else {
            Mapper<T> temp = this.next;
            while (temp!=null) {
                temp = temp.getNext();
            }
            Mapper<T> next = new Mapper<T>();
            next.setItem(item);
            temp.setNext(next);
        }
    }



    public void show(){

        Mapper<T> temp;
        do{
            System.out.println(this.getItem());
             temp = this.getNext();
        }while (temp !=null);

    }

}
