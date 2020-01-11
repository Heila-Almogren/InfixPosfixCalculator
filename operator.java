/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class operator {
    public String op;
    public int pr;
    
    public operator(String op, int pr){
        this.op = op;
        this.pr = pr;
    }
    
    public operator(String op){
        this.op = op;
        switch (op){
            case ">=" :  pr = 1;
            break;
            case  ">" : pr = 1;
            break;
            case "<=" : pr = 1;
            break;
            case  "<" : pr = 1;
            break;
            case "+" : pr = 2;
            break;
            case "-" : pr = 2;
            break;
            case "*" : pr = 3;
            break;
            case "/" : pr = 3;
            break;
            case "%" : pr = 3;
            break;
            default:  pr = -1;
    }
    }
    
    
    
}
