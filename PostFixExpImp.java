/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author heila
 */
public class PostFixExpImp implements PostFixExp {
    String PostFixExp;

    public void setExp(String exp){
        PostFixExp = exp;
}
    
    public String getExp(){
      return PostFixExp;
}
    
    public Stack<Integer> evaluate(int k){
        Stack Ev = new LinkedStack<Integer>();
        Stack temp = new LinkedStack<String>();
        
        String x[] = PostFixExp.split(" ");
        
        for (int i = k-1; i >= 0 ; i--){
            temp.push(x[i]);
        }
        
        while(!temp.empty()){
            
            String T = (String)temp.pop();
            
            switch(T){
                case "+": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b+a); }
                }
                break;
                case "-": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b-a); }
                }
                break;
                case "*": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b*a); }
                }
                break;
                case "/": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    if(a == 0){
                        return null;
                    }else
                    Ev.push(b/a); }
                    
                }
                break;
                case ">": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b>a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;        
                case ">=": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b>=a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;
                case "<": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b<a)
                            Ev.push(1);
                        else
                            Ev.push(0); } 
                }
                break;
                case "<=": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return null;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b<=a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;
                default:
                    if(Character.isDigit(T.charAt(0))){
                        Ev.push(T.charAt(0));
                    }
            }
        
        
        
}
        return Ev;
    }
    @Override
    public int validate(){
        int val = -1;
        
        Stack Ev = new LinkedStack<Integer>();
        Stack temp = new LinkedStack<String>();
        
        String x[] = PostFixExp.split(" ");
        
        for (int i = x.length-1; i >= 0 ; i--){
            temp.push(x[i]);
        }
        int c = -1;
        while(!temp.empty()){
            
            String T = (String)temp.pop();
            c++;
            
            switch(T){
                case "+": {
                    String y = Ev.pop().toString(); 
                    String z = Ev.pop().toString(); 
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b+a); }
                    }
                break;
                case "-": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b-a); }
                    }
                break;
                case "*": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    Ev.push(b*a); }
                }
                break;
                case "/": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                    if(a == 0){
                        return c;
                    }else
                    Ev.push(b/a); }
                }
                break;
                case ">": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b>a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;        
                case ">=": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b>=a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;
                case "<": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b<a)
                            Ev.push(1);
                        else
                            Ev.push(0); } 
                }
                break;
                case "<=": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b<=a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;
                
                case "!=": {
                    String y = Ev.pop().toString();
                    String z = Ev.pop().toString();
                    
                    if (!legalString(y)||!legalString(z))
                        return c;
                        else{
                    int a = Integer.parseInt(y);
                    int b = Integer.parseInt(z);
                        
                        if (b!=a)
                            Ev.push(1);
                        else
                            Ev.push(0); }
                }
                break;
                default:
                    if(Character.isDigit(T.charAt(0))){
                        Ev.push(T.charAt(0));
                    }
            }
        
            
        
        
}
      int n = 0;
      
      while(!Ev.empty()){
          Ev.pop();
          n++;
      }
      if (n!=1){
          return ++c;
      }
        return val;
    }
        
        
            
        
    @Override
    public InFixExp toInFix(){
         
        Stack <String> stats = new LinkedStack();
        Stack <String> temp = new LinkedStack();
        String x[] = (PostFixExp).split(" ");
        
        
        
        for (int i = x.length -1; i >= 0 ; i--){        
            temp.push(x[i]); }
        
        
        while(!temp.empty()){
                String n = temp.pop();
                if (operator(n)){
                    
                    String first = stats.pop();
                    String second = stats.pop();
                    
                    stats.push("( " + second + " " + n + " " + first + " )");
                }else{
                    
                    stats.push(n);
                }
        }
        
        
        /*
        Stack stat = new LinkedStack();
        Stack num = new LinkedStack<Integer>();
        Stack op = new LinkedStack<Integer>();
        Stack temp = new LinkedStack<String>();
        
        String x[] = PostFixExp.split(" ");
        
        for (int i = x.length-1; i >= 0 ; i--){
            temp.push(x[i]);
        }
        
        while (!temp.empty()){
            String n = temp.pop().toString();
            
            if (legalString(n)){
                num.push(n);
            }else if (operator(n)){
                op.push(n);
            }
        }
        */
        
        InFixExp E = new InFixExpImp();      //change later
        String res = stats.pop().toString();
        E.setExp(res);
        return E;
}
    
    public boolean legalString(String s){
        boolean b = false;
        if (s != null){
            b = true;
            for (int i = 0; i< s.length(); i++){
                if(!Character.isDigit(s.charAt(i))){
                    b = false;
                }
            }
        }
    return b;
}
    
    
    public boolean operator(String n){
            return (n.equals("*") || n.equals("/") || n.equals("%") || n.equals("$") || n.equals("+") || n.equals("-") || n.equals(">=") || n.equals(">") || n.equals("<=") || n.equals("<"));
                
        }
}

