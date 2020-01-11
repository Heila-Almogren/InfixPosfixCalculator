/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class InFixExpImp implements InFixExp {
    
    String InFixExp;
    LinkedStack <Integer> num = new LinkedStack<Integer>();
    LinkedStack <String> op = new LinkedStack<String>();
    
    @Override
    public void setExp(String exp){
        InFixExp = exp;
    }

	// Return the expression in infix notation (without $).
    @Override
    public String getExp(){
        //int len = InFixExp.length();
        //String s = InFixExp.substring(1, len -2);
            //return s;
            return InFixExp;
        }

	// Return the number of tokens in the expression (including $).
@Override	
    public int getNbTokens(){
            String x[] = InFixExp.split(" ");
            return x.length; //change later
        }
        
	// Return a pair containing respectively operands and operations stacks after parsing k tokens ($ is considered as a token). If an error is encountered before k tokens are parsed, null is returned. An error can be a syntax error or division by zero. Assume that k is valid.
@Override	
    public Pair<Stack<Integer>, Stack<String>> evaluate(int k){
            
            
            
        Stack <String> temp = new LinkedStack<String>();
        
        String x[] = (InFixExp + " $").split(" ");
        
        //inserting all string values in the stack
        for (int i = k-1; i >= 0 ; i--){        
            temp.push(x[i]); }
            
            
            
            int c = 0;
        while(!temp.empty()){       //start distributing items of the stack
           String n = temp.pop().toString();
           c++;
           //System.out.println("------- " + c + ". checking " + n + " -------");  
            if (legalNumber(n)){       //it's either a number
                 num.push(safeParse(n));
                 //System.out.println(n + " was inserted as a number");  
            }
            
            else {     //or it's not a number
                 if (operator(n)){
                     //System.out.println(n + " is an operator");
                        switch (n){
                           case "+":
                                 if (op.empty() || shallPrecede("+", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("+", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                             break;
                           case "-":
                                 if (op.empty() || shallPrecede("-", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("-", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                //    
                case "*" : op.push("*");
                //System.out.println(n + " is pushed directly");
                        break;
                        
                case "/" : 
                    //System.out.println(n + " is pushed directly");
                    op.push("/");                       
                        break;
                        
                case "%" : 
                    //System.out.println(n + " is pushed directly");
                    op.push("%");
                        break;
                     
                case ">":
                         
                         if (op.empty() || shallPrecede(">", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                case ">=":
                         
                         if (op.empty() || shallPrecede(">=", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     break;
                     
                     
                     case "<":
                         
                         if (op.empty() || shallPrecede("<", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                     case "<=":
                         if (op.empty() || shallPrecede("<=", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     
                    
                     break;
                     case "$": 
                         if (!temp.empty()){
                             return null;
                         }
                         //System.out.println("find the dollar!");
                         
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                         
                         num.push(perform (opf, g, d));       //ahh
                         
                         }
                
        }
                           
                     break;
                     
                     
                     }  //end switch  
                 }else{         //not an operator, it's either "(" or ")"
                     
                     if (n.equals(")")){        //shall work until it finds (
                         
                         //System.out.println("closing an operation:");
                     
                     
                     String operation = op.pop().toString();
                     while (!operation.equals("(")){
                     //operation =         //pop one sign
                     
                         String y = num.pop().toString();       //pop two numbers
                         String z = num.pop().toString();
                         if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int a = safeParse(y);       //safely parse integrs
                         int b = safeParse(z);
                         
                         
                         
                switch (operation){
                     case "+":  
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(b+a);      //paste here
                     //System.out.println("pushed " + (a+b));
                     break;
                     case "-":  
                         //System.out.println(b + "and " + a + "is " + (b-a));
                         num.push(b-a);
                     //System.out.println("pushed " + (b-a));
                     break;
                     case "*":  
                         //System.out.println(b + "and " + a + "is " + (b*a));
                         num.push(b*a);
                     //System.out.println("pushed " + (a*b));
                     break;
                     case "/":   if (a==0) return null; 
                     //System.out.println(b + "and " + a + "is " + (b/a));
                     num.push(b/a);
                     break;
                     case "%":   if (a==0) return null; 
                     //System.out.println(b + "and " + a + "is " + (b%a));
                     num.push(b%a);
                     break;
                     case ">":   if (b>a) num.push(1); 
                     else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case ">=":  if (b>=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b>=a));
                         num.push(0);};
                     break;
                     case "<":   if (b<a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case "<=":  if (b<=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case "$":
                         
                     {
                         //System.out.println("dollar sign");
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                
        }
                         
                        
                     }
                     
                     
                     
                         
                 }
                operation = op.pop().toString();
                 }
                         
                         
                     }else if (n.equals("(")){
                         op.push(n);
                         //System.out.println(n +" was inserted as an operator");
                         //continue;
                     }
                     
                     
                 }
                 
                 
                 
             }
            
            
            
        }       //now temp is temp
        op.push("$");
            
            Pair<Stack<Integer>,Stack<String>> w =new Pair <Stack<Integer>,Stack<String>>(num, op);
            return w;
            
            //END OF EVALUATE
        }
 

	// Check if the expression is valid (no syntax error and no division by zero). If the expression is invalid, the index of the token that caused the error is returned. If the expression is valid, the method returns -1.
	@Override
        public int validate(){      
            
            int open = 0;
            int close = 0;
            String L[] = InFixExp.split(" ");
            
            if (bracketChecker(InFixExp) != -1){
                return bracketChecker(InFixExp);
            }else{
                
                //System.out.println("START OF CHECKING");
                
                        Stack <String> temp = new LinkedStack<String>();
        
        String x[] = InFixExp.split(" ");
        
        //inserting all string values in the stack
        for (int i = InFixExp.length() -1; i >= 0 ; i--){        
            temp.push(x[i]); }
            
            
            
            int c = 0;
        while(!temp.empty()){       //start distributing items of the stack
           String n = temp.pop().toString();
           c++;
           //System.out.println("------- " + c + ". checking " + n + " -------");  
            if (legalNumber(n)){       //it's either a number
                 num.push(safeParse(n));
                 //System.out.println(n + " was inserted as a number");  
            }
            
            else {     //or it's not a number
                 if (operator(n)){
                     //System.out.println(n + " is an operator");
                        switch (n){
                           case "+":
                                 if (op.empty() || shallPrecede("+", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("+", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                             break;
                           case "-":
                                 if (op.empty() || shallPrecede("-", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("-", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                //    
                case "*" : op.push("*");
                //System.out.println(n + " is pushed directly");
                        break;
                        
                case "/" : 
                    //System.out.println(n + " is pushed directly");
                    op.push("/");                       
                        break;
                        
                case "%" : 
                    //System.out.println(n + " is pushed directly");
                    op.push("%");
                        break;
                     
                case ">":
                         
                         if (op.empty() || shallPrecede(">", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                case ">=":
                         
                         if (op.empty() || shallPrecede(">=", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     break;
                     
                     
                     case "<":
                         
                         if (op.empty() || shallPrecede("<", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                     case "<=":
                         if (op.empty() || shallPrecede("<=", op.peak().toString())){
                                     System.out.println(n + " is pushed directly");
                                 op.push(n);}
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                    String y = num.pop().toString();       //pop two numbers
                                    String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return c; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            num.push(perform(priper, a , b));
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                                    }   //end while
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     
                    
                     break;
                     case "$": 
                         //System.out.println("find the dollar!");
                         
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return c;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                         
                         num.push(perform (opf, g, d));       //ahh
                         
                         }
                
        }
                     break;
                     
                     
                     }  //end switch  
                 }else{         //not an operator, it's either "(" or ")"
                     
                     if (n.equals(")")){        //shall work until it finds (
                         
                         //System.out.println("closing an operation:");
                     
                     
                     String operation = op.pop().toString();
                     while (!operation.equals("(")){
                     //operation =         //pop one sign
                     
                         String y = num.pop().toString();       //pop two numbers
                         String z = num.pop().toString();
                         if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return c;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int a = safeParse(y);       //safely parse integrs
                         int b = safeParse(z);
                         
                         
                         
                switch (operation){
                     case "+":  
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(b+a);      //paste here
                     //System.out.println("pushed " + (a+b));
                     break;
                     case "-":  
                         //System.out.println(b + "and " + a + "is " + (b-a));
                         num.push(b-a);
                     //System.out.println("pushed " + (b-a));
                     break;
                     case "*":  
                         //System.out.println(b + "and " + a + "is " + (b*a));
                         num.push(b*a);
                     //System.out.println("pushed " + (a*b));
                     break;
                     case "/":   if (a==0) return c; 
                     //System.out.println(b + "and " + a + "is " + (b/a));
                     num.push(b/a);
                     break;
                     case "%":   if (a==0) return c; 
                     //System.out.println(b + "and " + a + "is " + (b%a));
                     num.push(b%a);
                     break;
                     case ">":   if (b>a) num.push(1); 
                     else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case ">=":  if (b>=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b>=a));
                         num.push(0);};
                     break;
                     case "<":   if (b<a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case "<=":  if (b<=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         num.push(0);}
                     break;
                     case "$": 
                         
                     {
                         //System.out.println("dollar sign");
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return c;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                
        }
                         
                         
                     }
                     
                     
                     
                         
                 }
                operation = op.pop().toString();
                 }
                         
                         
                     }else if (n.equals("(")){
                         op.push(n);
                         //System.out.println(n +" was inserted as an operator");
                         //continue;
                     }
                     
                     
                 }
                 
                 
                 
             }
            
            
            
        }
                
                //System.out.println("END OF CHECKING");
            }
        return -1;
        }
        
	// Return the expression in postfix notation. If a syntax error is encountered, null is returned (notice that division by zero is not considered an error here. Tokens must be separated by a space.
	public PostFixExp toPostFix(){
             PostFixExp x = new PostFixExpImp();
             String t = "";
             //WHAT IS THAAAAAT UGH
             
             
             Stack <String> temp = new LinkedStack<String>();
        
        String u[] = (InFixExp + " $").split(" ");
        
        //inserting all string values in the stack
        for (int i = u.length-1; i >= 0 ; i--){        
            temp.push(u[i]); }
            
            
            
            int c = 0;
        while(!temp.empty()){       //start distributing items of the stack
           String n = temp.pop().toString();
           c++;
           //System.out.println("------- " + c + ". checking " + n + " -------");  
            if (legalNumber(n)){       //it's either a number
                 num.push(safeParse(n));
                 //System.out.println(n + " was inserted as a number");  
            }
            
            else {     //or it's not a number
                 if (operator(n)){
                     //System.out.println(n + " is an operator");
                        switch (n){
                           case "+":
                                 if (op.empty() || shallPrecede("+", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 //t = t + " " + n;
                                    op.push(n);
                                 
                                 }
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("+", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                                        
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                             break;
                           case "-":
                                 if (op.empty() || shallPrecede("-", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 //t = t + " " + n;
                                    op.push(n);
                                 
                                 }
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("-", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                                        
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                //    
                case "*" : op.push("*");
                //System.out.println(n + " is pushed directly");
                
                        break;
                        
                case "/" : 
                    //System.out.println(n + " is pushed directly");
                    op.push("/");    
                    
                        break;
                        
                case "%" : 
                    //System.out.println(n + " is pushed directly");
                    
                    op.push("%");
                        break;
                     
                case ">":
                         
                         if (op.empty() || shallPrecede(">", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 op.push(n);
                                 //t = t + " " + n;
                         
                         }
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                 
                                 op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                case ">=":
                         
                         if (op.empty() || shallPrecede(">=", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                 //t = t + " " + n;
                                op.push(n);
                         
                         }
                                 else {
                             
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede(">=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                                    
                                                    op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     break;
                     
                     
                     case "<":
                         
                         if (op.empty() || shallPrecede("<", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                            //t = t + " " + n;
                            op.push(n);
                                 
                         }
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                                        
                                                        op.push(n);
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     break;
                     
                     
                     case "<=":
                         if (op.empty() || shallPrecede("<=", op.peak().toString())){
                                     //System.out.println(n + " is pushed directly");
                                //t = t + " " + n; 
                                op.push(n);
                         
                         }
                                 else {
                                     //System.out.println("there is more important one before");
                                 while(!op.empty()&&!shallPrecede("<=", op.peak().toString())&&!op.peak().toString().equals("(")){
                                     
                                     if (!num.hasTwoElements()){
                                         
                                 t = t + " " + op.pop().toString();
                             }else{
                                         String y = num.pop().toString();       //pop two numbers
                                         String z = num.pop().toString();
                                        if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                                         

                                        return null; }
                                        else{
                                            int a = Integer.parseInt(y);
                                            int b = Integer.parseInt(z);
                                            String priper = op.pop().toString();
                                            //System.out.println("popped " + priper + " with " + a + " and " + b);
                                            //num.push(perform(priper, a , b));
                                            t = t + " " + b + " " + a + " " + priper;
                                            //System.out.println("numbers " + a + " and " + b + ", operation is " + priper);
                                        }
                                     }
                                    
                                                    }   //end while
                                                        op.push(n);
                                                        
                                                        //System.out.println(n + "was added as an operator");
                             
                         } //end else
                     
                     
                    
                     break;
                     /*
                     case "$": 
                         if (!temp.empty()){
                             return null;
                         }
                         //System.out.println("find the dollar!");
                         
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                         
                         num.push(perform (opf, g, d));       //ahh
                         
                         }
                
        } 
                           
                     break;     */
                     
                     
                     }  //end switch  
                 }else{         //not an operator, it's either "(" or ")"
                     
                     if (n.equals(")")){        //shall work until it finds (
                         
                         //System.out.println("closing an operation:");
                     
                     
                     String operation = op.pop().toString();
                     
                     
                     
                     while (!operation.equals("(")){
                     //operation =         //pop one sign
                     
                     if (num.empty()){
                         t = t + " " + operation;
                         
                         continue;
                     }
                     
                         String y = num.pop().toString();       //pop two numbers
                         String z = num.pop().toString();
                         if (!legalNumber(y)||!legalNumber(z)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int a = safeParse(y);       //safely parse integrs
                         int b = safeParse(z);
                         
                         
                         
                switch (operation){
                     case "+":  
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         t = t + " " + b + " " + a + " " + operation;
                         //num.push(b+a);      //paste here
                     //System.out.println("pushed " + (a+b));
                     break;
                     case "-":  
                         //System.out.println(b + "and " + a + "is " + (b-a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(b-a);
                     //System.out.println("pushed " + (b-a));
                     break;
                     case "*":  
                         //System.out.println(b + "and " + a + "is " + (b*a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(b*a);
                     //System.out.println("pushed " + (a*b));
                     break;
                     case "/":   if (a==0) return null; 
                     //System.out.println(b + "and " + a + "is " + (b/a));
                     t = t + " " + b + " " + a + " " + operation; 
                     //num.push(b/a);
                     break;
                     case "%":   if (a==0) return null; 
                     //System.out.println(b + "and " + a + "is " + (b%a));
                     t = t + " " + b + " " + a + " " + operation; 
                     //num.push(b%a);
                     break;
                     case ">":   //if (b>a) num.push(1); 
                     //else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(0);
                     //}
                     break;
                     case ">=":  
                         //if (b>=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b>=a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(0);
                     //};
                     break;
                     case "<":   
                         //if (b<a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(0);
                     //}
                     break;
                     case "<=":  
                         //if (b<=a) num.push(1); else { 
                         //System.out.println(b + "and " + a + "is " + (b+a));
                         t = t + " " + b + " " + a + " " + operation; 
                         //num.push(0);
                     //}
                     break;
                     case "$":
                       t = t + " " + b + " " + a + " " + operation; 
                         /*  
                     {
                         //System.out.println("dollar sign");
                           while(!op.empty()){
                //System.out.println("dollar sign loop");
                     
                     String opf = op.pop().toString();
                     
                     //operation =         //pop one sign
                     
                         String l = num.pop().toString();       //pop two numbers
                         //System.out.println("y is " + y);
                         String m = num.pop().toString();
                         //System.out.println("z is " + z);
                         if (!legalNumber(l)||!legalNumber(m)){     //if numbers are invalid, return
                             //System.out.println("NOT LEGAL");
                             return null;
                         }else{
                             //System.out.print("popped " + y + " and " + z + ", ");
                             //System.out.println("operation is " + operation);
                         }
                         int g = Integer.parseInt(l);       //safely parse integrs
                         int d = Integer.parseInt(m);
                
        }
                         
                        
                     }  */
                     
                     
                     
                         
                 }
                operation = op.pop().toString();
                 }
                         
                         
                     }else if (n.equals("(")){
                         op.push(n);
                         //System.out.println(n +" was inserted as an operator");
                         //continue;
                     }
                     
                     
                     
                 }
                 
                 
                 
             }
            
            
            
        }       //now temp is temp
        
        while(!op.empty()){
            t = t + " " + op.pop();
        }
        op.push("$");
            
            //END OF EVALUATE
             
             //ok at least i tried
             PostFixExp conv = new PostFixExpImp();
             conv.setExp(t.substring(1, t.length() -1));
             return conv;
        }
        
        
        public boolean legalNumber(String s){
            
        boolean b = false;
        if (s != null){
            char h = s.charAt(0);
            int prefix = 0;
            if(h == '-'){
                if(s.length() == 1){
                    return false;
                }else{
                    prefix = 1;
                }
            }
            b = true;
            //System.out.println(s + " is not null");
            for (int i = prefix; i< s.length(); i++){
                if(!Character.isDigit(s.charAt(i))){
                    b = false;
                    //System.out.println(s + " there is a character thats is not a digit!!");
                }
            }
        }
    return b;
}
        
        
        public int safeParse(String s){
            //System.out.println("safely parsing " + s);
            int parsed;
            String p = s;
            char f = s.charAt(0);
            if (f == '-'){
                //System.out.println(s + " a minus number");
                s = s.substring(1);
            parsed = -1 * (Integer.parseInt(s));}
            else{
                parsed = Integer.parseInt(s);
           
        }
            return parsed;
        }
        
        public int perform(String opf, int a, int b){
            
            switch (opf){
                     case "+":  return b+a;
                     //System.out.println("pushed " + (a+b));
                     
                     case "-":  return b-a;
                     //System.out.println("pushed " + (b-a));
                     
                     case "*":  return b*a;
                     //System.out.println("pushed " + (a*b));
                     
                     case "/":   if (a==0) return b/a;
                     
                     case ">":   if (b>a) return 1; else return 0;
                     
                     case ">=":  if (b>=a) return 1; else return 0;
                     
                     case "<":   if (b<a) return 1; else return 0;
                     
                     case "<=":  if (b<=a) return 1; else return 0;
                     
                     
                 }
            
            return -1;
            
        }
        
        public boolean shallPrecede (String a, String b){
            
            
            operator op1 = new operator (a);
            operator op2 = new operator (b);
            //System.out.println("priority is " + op2.pr);
            if (op2.pr == -1){
                //System.out.println(b + " has no priority so it's ok to procede");
                return true;
            }
                
            
            //System.out.println("priority of " + a + " > " + b + " ?" + (op1.pr > op2.pr));
            return op1.pr > op2.pr;
            
        }
        
        
        public boolean operator(String n){
            return (n.equals("*") || n.equals("/") || n.equals("%") || n.equals("$") || n.equals("+") || n.equals("-") || n.equals(">=") || n.equals(">") || n.equals("<=") || n.equals("<"));
                
        }
        
        public int bracketChecker(String B){
            
            String x[] = InFixExp.split(" ");
            int rep = 0;
            for (int i = 0; i < x.length; i++) {
                //System.out.println("----- iteration " + i + " (" + x[i] + ") -----");
                rep = 0;
                if (x[i].equals("(")){      //found an opening
                    //System.out.println("- found ( : go through all next characters");
                    rep = 1;
                    for (int k = i+1; k < x.length; k++){
                    //System.out.println("    checking " + x[k]);
                    if (x[k].equals("(")){
                        //System.out.println("it's (");
                        rep++;
                    }
                    if (x[k].equals(")")&&rep>1){
                        //System.out.println("there is previous )");
                            rep--;
                    }else if (x[k].equals(")")&&rep==1){
                        rep--;
                        //System.out.println("stop searching in next characters");
                        break;
                    }
                    
                    
                }
                    //System.out.println("repetition is " + rep);
                    if (rep != 0){
                        
                        //System.out.println("repetition not equal 0");
                        //System.out.println(rep);
                        return i;
                    }
                }
                else if (x[i].equals(")")) {        //found a closing
                    
                //System.out.println("- found ) : go through all previous characters");

                    rep = 1;
                    for (int k = i-1; k >= 0; k--){
                    //System.out.println("    checking " + x[k]);
                    if (x[k].equals(")")){
                        //System.out.println("it's )");
                            rep++;
                    }
                    if (x[k].equals("(")&&rep>1){
                        //System.out.println("there is previous");
                        rep--;
                    }else if (x[k].equals("(")&&rep==1){
                        //System.out.println("no previous");
                        rep--;
                        //System.out.println("stop searching in previous characters");
                        break;
                    }
                    
                    
                    
                }
                    //System.out.println("repetition is " + rep);
                    if (rep != 0){
                        //System.out.println("repetition not equal 0");
                        //System.out.println(rep);
                        return i;
                    }
                }
                //System.out.println("----------");

        }
            //System.out.println("repetition is " + rep);
            return -1;
        }
        
}
