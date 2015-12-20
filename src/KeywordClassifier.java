import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Include X
 *Declare X
 *->ID X
 *->Function X
 *Change X
 *->ID X
 *->Arrays X
 *pointer  X
 *struct   X
 *Block  X 
 *Expression ?
 *Control Structures X
 *Hash Map
 *Find 
 *Copy
 *Cut
 *Paste
 *Replace
 *Open Editor
 */


public class KeywordClassifier {
	static ArrayList<String> al = new ArrayList<String>();
    static String [] datatypes={ "int","float","char","double","long"};
    static String prog="";
public static String voiceInclude()
{System.out.println("Include Mode");
 //Scanner scan=new Scanner(System.in);
 //String s=scan.next();
String s=voceRecognize();
 String include="";
 while(!s.equalsIgnoreCase("end"))
 {if(s.equalsIgnoreCase("standard"))
 {     System.out.println("Standard Libraries");
     include+="#include<stdio.h>\n#include<conio.h>\n#include<math.h>";
     
 }
 else if(s.equalsIgnoreCase("system"))
 {   System.out.println("System Libraries");
     include="#include<"+alphabetRecognize()+".h>";
 }
 else if(s.equalsIgnoreCase("library"))
 {   System.out.println("User Defined Libraries");
     include+="#include \""+alphabetRecognize()+".h\"";
 }
 //s=scan.next();
 s=voceRecognize();}
 System.out.println("Library Recognized: "+include);
return include+"\n";}

public static String voiceMacro()
{
	String macro_name="";
	System.out.println("Waiting for Macro Name");
	macro_name+=alphabetRecognize();
	System.out.println("Waiting for Macro Definition");
	String macro_definition=alphabetRecognize();
	return "#define "+macro_name+" "+macro_definition;
}

public static String alphabetRecognize()
{
boolean upper_case=false; 
int upper_case_start=0;
int upper_case_end=0;
System.out.println("Alphabet mode");
Scanner scan=new Scanner(System.in);
//String s=scan.next();
String s=voceRecognize();
String word="";
while(!s.equalsIgnoreCase("end"))
{

System.out.println("Word Recognized: "+word);
if(s.length()>0)
{
if(s.equalsIgnoreCase("digit"))
{
    word+=numberRecognize("integer");
    s=voceRecognize();
    continue;
}
else if(s.equalsIgnoreCase("capital"))
{   System.out.println("Upper Case+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	upper_case=true;
	upper_case_start=word.length();
	s=voceRecognize();
	continue;

}
else if(s.equalsIgnoreCase("small"))
{	System.out.println("Lower Case");
	upper_case=false;
	String new_word=word.substring(0,upper_case_start);
	upper_case_end=word.length();
	for(int i=upper_case_start;i<upper_case_end;i++)
	{	new_word+=Character.toUpperCase(word.charAt(i));;
	}
	word=new_word;
	System.out.println(word);
	//s=scan.next();
	s=voceRecognize();
	continue;

}
else if(s.equalsIgnoreCase("character"))
{
    word+=characterRecognize();
    s=voceRecognize();
    //s=scan.next();
    continue;
}
else if(s.equalsIgnoreCase("delete"))
{   System.out.println(word);
	if(word.length()>0)
	{
    word=word.substring(0, word.length()-1);
    System.out.println(word);
    
    //s=scan.next();
    }
	s=voceRecognize();
    continue;
}
else if(s.contains("term"))
{
    word+=";";
    s=voceRecognize();
    //s=scan.next();
    continue;
}
else if(s.equalsIgnoreCase("return")||s.equalsIgnoreCase("line")||s.equalsIgnoreCase("enter"))
{   System.out.println("NEW ++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    word+="\n";
    s=voceRecognize();
    //s=scan.next();
    continue;
}
else if(s.equalsIgnoreCase("space"))
{
    word+=" ";
    s=voceRecognize();
    //s=scan.next();
    continue;
}
switch(s.toLowerCase().charAt(0))
    {
case 'a':
{word+='a';
break;}
case 'b':
{
    word+='b';
    break;
}
case 'c':
{
    word+='c';
    break;
}
case 'd':
{
    word+='d';
    break;
}
case 'e':
{
    word+='e';
    break;
}
case 'f':
{
    word+='f';
    break;
}
case 'g':
{
    word+='g';
    break;
}
case 'h':
{
    word+='h';
    break;
}
case 'i':
{
    word+='i';
    break;
}
case 'j':
{
    word+='j';
    break;
}
case 'k':
{
    word+='k';
    break;
}
case 'l':
{
    word+='l';
    break;
}
case 'm':
{
    word+='m';
    break;
}
case 'n':
{
    word+='n';
    break;
}
case 'o':
{
    word+='o';
    break;
}
case 'p':
{
    word+='p';
    break;
}
case 'q':
{
    word+='q';
    break;
}
case 'r':
{
    word+='r';
    break;
}
case 's':
{
    word+='s';
    break;
}
case 't':
{
    word+='t';
    break;
}
case 'u':
{
    word+='u';
    break;
}
case 'v':
{
    word+='v';
    break;
}
case 'w':
{
    word+='w';
    break;
}
case 'x':
{
    word+='x';
    break;
}
case 'y':
{
    word+='y';
    break;
}
case 'z':
{
    word+='z';
    break;
}
    }
}

else
{
	System.out.println("Empty");
}

s=voceRecognize();
//s=scan.next();
}
if(upper_case)
{
	String new_word=word.substring(0,upper_case_start);
	upper_case_end=word.length();
	for(int i=upper_case_start;i<upper_case_end;i++)
	{	new_word+=Character.toUpperCase(word.charAt(i));;
	}
	word=new_word;
	System.out.println(word);
}
System.out.println("Final Word Recognized: "+word);
return word;}
    
public static String numberRecognize(String input)
{System.out.println("Number Mode");
Scanner scan=new Scanner(System.in);
int flag_decimal_point=0;
if(input.equalsIgnoreCase("double")|input.equalsIgnoreCase("float"))
{
    flag_decimal_point=1;
}
//String s=scan.next();
String s=voceRecognize();
String num="";
while(!s.equalsIgnoreCase("end"))
{
System.out.println("Number Recognized: "+num);
if(s.equalsIgnoreCase("delete"))
{   System.out.println(num);
	if(num.length()>0)
	{
    num=num.substring(0, num.length()-1);
    System.out.println(num);
    //s=scan.next();
    }
	s=voceRecognize();
    continue;
 }
else if(s.equals("point")&& flag_decimal_point==1)
    {num+=".";}
else if(s.equalsIgnoreCase("zero"))
{num+="0";
}
else if(s.equalsIgnoreCase("one")||s.equalsIgnoreCase("line"))
{
    num+="1";
}
else if(s.equalsIgnoreCase("two")||s.equalsIgnoreCase("do"))
{
    num+="2";
}
else if(s.equalsIgnoreCase("three")||s.equalsIgnoreCase("triple"))
{
    num+="3";
}
else if(s.equalsIgnoreCase("four")||s.equalsIgnoreCase("for"))
{
    num+="4";
}
else if(s.equalsIgnoreCase("five")||s.equalsIgnoreCase("pipe"))
{
    num+="5";
}
else if(s.equalsIgnoreCase("six"))
{
    num+="6";
}
else if(s.equalsIgnoreCase("seven"))
{
    num+="7";
}
else if(s.equalsIgnoreCase("eight"))
{
    num+="8";
}
else if(s.equalsIgnoreCase("nine"))
{
    num+="9";
}
System.out.println("Waiting for Input");
//s=scan.next();
s=voceRecognize();
}
System.out.println("Final Number Recognized: "+num);
return num;

}

public static String characterRecognize()
{ System.out.println("Character Mode");
 Scanner scan=new Scanner(System.in);
 //String s=scan.next();
 String s=voceRecognize();
 String characters="";
while (!s.equalsIgnoreCase("end"))
{System.out.println("Character Mode");
if(s.equalsIgnoreCase("delete"))
{   System.out.println(characters);
if(characters.length()>0)
{
characters=characters.substring(0, characters.length()-1);
    System.out.println(characters);
    //s=scan.next();
    
}	s=voceRecognize();
    continue;
 }
else if(s.equalsIgnoreCase("space"))    
    {
        characters+=" ";
    }
else if(s.equalsIgnoreCase("tab"))    
{
    characters+=" ";
}
else if(s.equalsIgnoreCase("return"))    
{
    characters+="\n";
}
else if(s.equalsIgnoreCase("not"))
{
    characters+="!";
}
else if(s.equalsIgnoreCase("at"))    
{
    characters+="@";
}
else if(s.equalsIgnoreCase("pound"))    
{
    characters+="#";
}
else if(s.equalsIgnoreCase("dollar"))    
{
    characters+="$";
}
else if(s.equalsIgnoreCase("percent"))    
{
    characters+="%";
}
else if(s.equalsIgnoreCase("exponent"))    
{
    characters+="^";
}
else if(s.equalsIgnoreCase("and")||s.equalsIgnoreCase("intersect"))    
{
    characters+="&";
}
else if(s.equalsIgnoreCase("or")||s.equalsIgnoreCase("pipe"))    
{
    characters+="|";
}
else if(s.equalsIgnoreCase("minus")||s.equalsIgnoreCase("dash"))    
{
    characters+="-";
}
else if(s.equalsIgnoreCase("score")||s.equalsIgnoreCase("under"))    
{
    characters+="_";
}
else if(s.equalsIgnoreCase("plus"))    
{
    characters+="+";
}
else if(s.equalsIgnoreCase("equal")||s.equalsIgnoreCase("equals"))    
{
    characters+="=";
}
else if(s.equalsIgnoreCase("star"))    
{
    characters+="*";
}
else if(s.equalsIgnoreCase("period")||s.equalsIgnoreCase("dot"))    
{
    characters+=".";
}
else if(s.equalsIgnoreCase("comma")||s.equalsIgnoreCase("come")||s.equalsIgnoreCase("coma"))  //coma in gram file?  
{
    characters+=",";
}
else if(s.equalsIgnoreCase("question")||s.equalsIgnoreCase("quest"))    
{
    characters+="?";
}

else if(s.equalsIgnoreCase("great"))
{characters+=">";}

else if(s.equalsIgnoreCase("less"))
{characters+="<";}

else if(s.equalsIgnoreCase("braces"))    
{//String next=scan.next();
	String next=voceRecognize();
	while(!next.equalsIgnoreCase("open")&&!next.equalsIgnoreCase("close"))
			{System.out.println("Waiting for open or close");
		next=voceRecognize();
			}
    if(next.equalsIgnoreCase("open"))
    {characters+="(";}
else if(next.equalsIgnoreCase("close"))
    {characters+=")";}
}
else if(s.equalsIgnoreCase("block"))    
{//String next=scan.next();
	String next=voceRecognize();
	while(!next.equalsIgnoreCase("open")&&!next.equalsIgnoreCase("close"))
	{System.out.println("Waiting for open or close");
	 next=voceRecognize();
	}
    if(next.equalsIgnoreCase("open"))
    {characters+="{";}
else if(next.equalsIgnoreCase("close"))
    {characters+="}";}
}
else if(s.equalsIgnoreCase("square"))    
{//String next=scan.next();
	String next=voceRecognize();
	while(!next.equalsIgnoreCase("open")&&!next.equalsIgnoreCase("close"))
	{System.out.println("Waiting for open or close");
	 next=voceRecognize();
	}
    if(next.equalsIgnoreCase("open"))
    {characters+="[";}
else if(next.equalsIgnoreCase("close"))
    {characters+="]";}
}
    

else if(s.equalsIgnoreCase("quote")||s.equalsIgnoreCase("code"))    
    
{System.out.println("quote");
//String next=scan.next();
String next=voceRecognize();
while(!next.equalsIgnoreCase("single")&&!next.equalsIgnoreCase("double"))
{System.out.println("Waiting for single or double");
next=voceRecognize();
}
if(next.equalsIgnoreCase("single"))
    {characters+="'";}
else if(next.equalsIgnoreCase("double"))
    {characters+="\"";}
}
else if(s.equalsIgnoreCase("slash"))
    
{  // String next=scan.next();
	String next=voceRecognize();
	while(!next.equalsIgnoreCase("forward")&&!next.equalsIgnoreCase("back"))
	{System.out.println("Waiting for forward or backward");
next=voceRecognize();
	}
    if(next.equalsIgnoreCase("forward"))
    {characters+="/";}
else if(next.equalsIgnoreCase("back"))
    {characters+="\\";}
}

else if(s.equalsIgnoreCase("colon"))    
{System.out.println("Colon");
//String next=scan.next();
String next=voceRecognize();
while(!next.startsWith("n")&&!next.startsWith("s"))
{System.out.println("Waiting for normal or semi");
next=voceRecognize();
}
if(next.charAt(0)=='n')
{characters+=":";}
else if(next.charAt(0)=='s')
{characters+=";";}
}
System.out.println("Characters Recognized: "+characters);
System.out.println("Waiting for Input");
//s=scan.next();
s=voceRecognize();}
System.out.println("Characters Recognized: "+characters);
return characters;}
    
public static String voiceDeclare(boolean value_flag)
{String str="";
System.out.println("Declare Mode");
Scanner scan=new Scanner(System.in);
System.out.println("Waiting for type: INTEGER FLOAT DOUBLE CHARACTER POINT LIST SPELL");
//String s=scan.next();
String s=voceRecognize();
while(!s.equalsIgnoreCase("integer")&&!s.equalsIgnoreCase("float")&&!s.equalsIgnoreCase("double")&&!s.equalsIgnoreCase("character")&&!s.equalsIgnoreCase("point")&&!s.equalsIgnoreCase("list")&&!s.equalsIgnoreCase("spell"))
 {	System.out.println("Waiting for type: INTEGER FLOAT DOUBLE CHARACTER POINT LIST SPELL");
	s=voceRecognize();
 }
if(s.equals("integer"))
    {System.out.println("Int mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
if(value_flag)
{System.out.println("Waiting for value");
 String value=numberRecognize(s);
 str=datatypes[0]+" "+name+" = "+value;
}
else
{
    str=datatypes[0]+" "+name;
}

    }
else if(s.equals("float"))
{System.out.println("Float mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
if(value_flag)
{System.out.println("Waiting for value");
String value=numberRecognize(s);
str=datatypes[1]+" "+name+" = "+value;}
else
    {str=datatypes[1]+" "+name;}
System.out.println(str);

}
else if(s.equals("character"))
{System.out.println("Character mode");
System.out.println("Waiting for name");
String name=alphabetRecognize();
while(name.length()==0)
{
	System.out.println("Waiting for name");
	name=voceRecognize();}
//String name =scan.next();
al.add(name);
if(value_flag)
{String valueString=voceRecognize();	
while(valueString.length()==0)
{System.out.println("Waiting for value");
valueString=voceRecognize();}
	char value=valueString.charAt(0);
    //char value=scan.next().charAt(0);
     str=datatypes[2]+" "+name+" = "+"'"+value+"'";
}
else
{str=datatypes[2]+" "+name;}

}
else if(s.equals("double"))
{System.out.println("Double mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
if(value_flag)
{System.out.println("Waiting for value");
String value=numberRecognize(s);
 str=datatypes[3]+" "+name+" = "+value;}
else
{
    str=datatypes[3]+" "+name;
}

}
else if(s.equals("long"))
{
System.out.println("Long mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
if(value_flag)
{    System.out.println("Waiting for value");
    String value=numberRecognize(s);
    str=datatypes[4]+" "+name+" = "+value;
}
else
{
    str=datatypes[4]+" "+name;
}

}
else if(s.contains("point"))
{System.out.println("Pointer mode");
System.out.println("Waiting for type");
String type=voceRecognize();
while(type.length()==0)
{	System.out.println("Waiting for type of pointer INTEGER CHARACTER FLOAT DOUBLE LONG SPELL");
	type=voceRecognize();
}
//String type =scan.next();
if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
{   
     if(type.equalsIgnoreCase("character"))
        {
        type="char";
        }
    if(type.equalsIgnoreCase("integer"))
        {
        type="int";
        }
    if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
        {
        type=alphabetRecognize();
        }
}
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
if(value_flag)
{System.out.println("Waiting for value. Null if left undefined.");
String value=alphabetRecognize();
    if(value.length()>0)
    {
        str=type+"* "+name+" = NULL";
    }

    else
    {
        str=type+"* "+name+" = &"+value;
    }
}
else
{
    str=type+"* "+name;
}

}

else if(s.contains("list"))
{System.out.println("Array mode");
System.out.println("Waiting for type");
String type=voceRecognize();
//String type =scan.next();
if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
{   if(type.equalsIgnoreCase("character"))
    {
    type="char";
    }
    if(type.equalsIgnoreCase("integer"))
    {
        type="int";
    }
    
    
    if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
    {
        type=alphabetRecognize();
    }
}
System.out.println("Waiting for size");
String size=numberRecognize("integer");//No Value Flag - Does not assign values to array.
System.out.println("Waiting for name");
String name =alphabetRecognize();
al.add(name);
//String value=alphabetRecognize();
 str=type+" "+name+"["+size+"]";

}

else if(s.equalsIgnoreCase("spell")||s.equalsIgnoreCase("sell"))//add to arraylist
{System.out.println("User Control mode");
String value=alphabetRecognize();
 str=value;
}
return str+";\n";
}

public static String voiceStructure()
{   Scanner scan=new Scanner(System.in);
    String s="";
    String body="";
    System.out.println("Structure mode");
    System.out.println("Waiting for name");
    String name=alphabetRecognize();
    String structure= "struct " + name +" \n{";
    do
    {System.out.println("Waiting for struct members");
    body+= voiceDeclare(false);
    s=voceRecognize();
    while(s.length()==0)
    {	System.out.println("NEXT to add additional struct members");
    	 s=voceRecognize();
    }
    //s=scan.next();
    }
    while(s.equalsIgnoreCase("next"));
    structure+=body;
    structure+="};\ntypedef struct "+name+" "+name+";";
    return structure;
}

public static String voicePrint()
{
    Scanner scan=new Scanner(System.in);
    System.out.println("Print mode");
    String all="";
    System.out.println("Waiting for message");
    //String value =scan.next();
    String value=voceRecognize();
    while(value.length()==0)
    {	System.out.println("Waiting for message");
    	value=voceRecognize();
    	
    }
    if(!value.equals("spell"))
    {
    while(!value.equalsIgnoreCase("end"))
    {if(value.length()>0)
    {
    if(all.length()==0)
    {all+=value;}
    else
    {all=all+" "+value;}
    //value=scan.next();
    }
    value=voceRecognize();
    }
    }
    else
   {	System.out.println("Spell Message");
    	all=alphabetRecognize();
    
   }
return "printf(\""+all+"\")";
}

public static String voiceControlStructures()
{System.out.println("Control Structures Mode");
    Scanner scan=new Scanner(System.in);
    System.out.println("Waiting for control structure: IF FOR WHILE DO-WHILE");
    //String s=scan.next();
    String s=voceRecognize();
    String word="";
    if(s.startsWith("i"))
     {System.out.println("If Block");
      String condition=alphabetRecognize();
      word+="if("+condition+")\n";
      String block=voiceBlocks();//replace 
      word+="{\n"+block+"\n}\n";
      //String next=scan.next();
      System.out.println("NEXT to switch to Else If Blocks. END to terminate.");
      String next=voceRecognize();
      while(!next.equalsIgnoreCase("end")&&!next.equalsIgnoreCase("next"))
      {	  System.out.println("NEXT to switch to Else If Blocks. END to terminate.");
    	  next=voceRecognize();  
      }
      if(next.equalsIgnoreCase("end"))//if directly to else switch missing
      {return word;}
      else if(next.equalsIgnoreCase("next"))
       {do
       {
          System.out.println("Else If Block");
          String condition_next=alphabetRecognize();
          word+="else if("+condition_next+")\n";
          String block_next=voiceBlocks();//replace 
          word+="{\n"+block_next+"\n}\n";
          //next=scan.next();
          System.out.println("NEXT to continue else if block. LAST to switch to else block.");
          next=voceRecognize();
          while(next.length()==0)
          {System.out.println("NEXT to continue else if block. LAST to switch to else block.");
          next=voceRecognize();
          }
       }while(next.equalsIgnoreCase("next"));
       }
      if(next.equalsIgnoreCase("last"))
     {      System.out.println("Else Block");
          word+="else\n";
          String block_last=voiceBlocks();//replace 
          word+="{\n"+block_last+"\n}\n";
          
     }
      }
    else if(s.equalsIgnoreCase("while"))
    {
          System.out.println("While Block");
          String condition=alphabetRecognize();
          word+="while("+condition+")\n";
          String block=voiceBlocks();//replace 
          word+="{\n"+block+"\n}\n";
          
    }
    else if(s.equalsIgnoreCase("for")||s.equalsIgnoreCase("four"))
    {
          System.out.println("For Block");
          String condition=alphabetRecognize();
          word+="for("+condition+")\n";
          String block=voiceBlocks();//replace 
          word+="{\n"+block+"\n}\n";
          
        
    }
    else if(s.startsWith("do")||s.equalsIgnoreCase("two"))
    {
          System.out.println("For Block");
          String block=voiceBlocks();//replace 
          word+="do\n{\n"+block+"\n}\n";
          String condition=voiceBlocks();
          word+="while("+condition+");\n";
        
          
        
    }
return word;}
public static String typeRecognize(String type)
{
	   if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
	    {   if(type.equalsIgnoreCase("character"))
	        {
	        type="char";
	        }
	        if(type.equalsIgnoreCase("integer"))
	        {
	            type="int";
	        }
	        if(type.equalsIgnoreCase("void") || type.equalsIgnoreCase("None") || type.equalsIgnoreCase("zero"))
	        {
	            type="void";
	        }
	        
	        if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
	        {
	            type=alphabetRecognize();
	        }
	    }
return type;}

public static String voiceFunction()
{   System.out.println("Function Mode");
    Scanner scan=new Scanner(System.in);
    System.out.println("Waiting for Declare/Call");
    //String declare_call=scan.next();
    String declare_call=voceRecognize();
    while(declare_call.length()==0)
    {	System.out.println("Waiting for Declare/Call");
    	declare_call=voceRecognize();
    }
    String function="";
    if(declare_call.equalsIgnoreCase("declare"))
    {System.out.println("Declare Function Mode Waiting for Return Type VOID SPELL DATATYPES");
    //String type =scan.next();
    String type=voceRecognize();
    while(type.length()==0||(!type.equalsIgnoreCase("integer"))&&(!type.equalsIgnoreCase("float"))&&type.equalsIgnoreCase("long")&&type.equalsIgnoreCase("double")&&type.equalsIgnoreCase("character")&&type.equalsIgnoreCase("void")&&type.equalsIgnoreCase("spell"))
    {	System.out.println("Waiting for Type");
    	type=voceRecognize();
    }
    type=typeRecognize(type);
 
    function+=type+" ";
    System.out.println("Waiting for funciton name");
    String name=alphabetRecognize();
    System.out.println("Waiting for Parameters");
    function+=name;
    //String s=scan.next();
    String s=voceRecognize();
    while(s.length()==0||(!type.equalsIgnoreCase("integer"))&&(!type.equalsIgnoreCase("float"))&&type.equalsIgnoreCase("long")&&type.equalsIgnoreCase("double")&&type.equalsIgnoreCase("character")&&type.equalsIgnoreCase("void")&&type.equalsIgnoreCase("spell"))
    {	System.out.println("Waiting for Parameters");
    	s=voceRecognize();
    }
    //s=typeRecognize(s);
    String parameter="";
    String parameters="";
    boolean void_flag=true;

    if(!s.equalsIgnoreCase("void") && !s.equalsIgnoreCase("None") && !s.equalsIgnoreCase("zero"))
        {void_flag=false;
        do
        {if(!s.equalsIgnoreCase("double")||!s.equalsIgnoreCase("float")||!s.equalsIgnoreCase("long"))//else if replace put segment inside function.
    {   if(s.equalsIgnoreCase("character"))
        {
        parameter="char";
        }
        if(s.equalsIgnoreCase("integer"))
        {
            parameter="int";
        }
        
        
        if(s.equalsIgnoreCase("spell")||s.equalsIgnoreCase("sell"))
        {
            parameter=alphabetRecognize();
        }
    }    if(parameters.length()==0)
          {parameters+=parameter;}
         else
         {parameters+=", "+parameter;}
         //s=scan.next();
    System.out.println("NEXT to continue parameters");
    	s=voceRecognize();
    	while(s.length()==0)
    	{System.out.println("NEXT to continue parameters");
    		s=voceRecognize();
    	}
        }while(s.equalsIgnoreCase("next"));
        }
    System.out.println("Waiting for block");
    String block=voiceBlocks();
    function+="("+parameters+")\n{\n"+block+"\n}";}
    
    else if(declare_call.equalsIgnoreCase("call"))
    {System.out.println("Waiting for function Call");
        function=alphabetRecognize();
        String parameters="";
        String s;
        do
        {
        String parameter=alphabetRecognize();
         if(parameters.length()==0)
          {parameters+=parameter;}
         else
         {parameters+=", "+parameter;}
         //s=scan.next();
         System.out.println("NEXT to continue parameters");
         s=variableChange();
         while(s.length()==0)
     	{System.out.println("NEXT to continue parameters");
     		s=","+variableChange();
     	}
    }while(s.equalsIgnoreCase("next"));
    }
return function;}

public static String voiceInput()
{
    Scanner scan=new Scanner(System.in);
    System.out.println("Input mode");
    String all="";
    System.out.println("Waiting for variable type");
    //String value =scan.next();
    System.out.println("Waiting for variable type. INTEGER CHARACTER FLOAT LONG DOUBLE STRING");
    String value=voceRecognize();//consider switching to alphabet for unknown types.
    while(value.length()==0)
    {	System.out.println("Waiting for variable type. INTEGER CHARACTER FLOAT LONG DOUBLE STRING");
    	value=voceRecognize();
    }
    System.out.println("Waiting for variable name.");
    String variable=alphabetRecognize();//value is type and variable is variable name
    String variables="";
    while(!value.equalsIgnoreCase("end"))
    { if(value.equalsIgnoreCase("integer"))
        {value="%d";
        }
    else if(value.equalsIgnoreCase("character"))
        {value="%c";}
    else if(value.equalsIgnoreCase("float"))
    {value="%f";}
    else if(value.equalsIgnoreCase("double"))
    {value="%lf";}
    else if(value.equalsIgnoreCase("long"))
    {value="%ld";}
    else if(value.equalsIgnoreCase("string"))
    {value="%s";}
    
    if(all.length()==0)
    {all+=value;
    variables+="&"+variable;}
    else
    {
    all=all+" "+value;
    variables +=", &"+variable;}
    System.out.println("Waiting for next variable type. INTEGER CHARACTER FLOAT LONG DOUBLE STRING");
    //value=scan.next();
    value=voceRecognize();//consider switching to alphabet for unknown types.
    while(value.length()==0)
    {	System.out.println("Waiting for next variable type. INTEGER CHARACTER FLOAT LONG DOUBLE STRING ");
    	value=voceRecognize();
    }
    if(value.equalsIgnoreCase("end"))
    {
        break;
    }
    System.out.println("Waiting for next variable name");
    variable=alphabetRecognize();
}

return "scanf(\""+all+"\","+variables+");";
}
    

public static String voiceBlocks()

{   System.out.println("Block Mode");
    Scanner scan=new Scanner(System.in);
    String block="";
   int start_index=al.size();
    //String s=scan.next();
    String s=voceRecognize();
    while(!s.equalsIgnoreCase("end"))
    {
        if(s.equalsIgnoreCase("declare"))
        {
            block+=voiceDeclare(true);
            for(String p:al)
            	{
            	System.out.println(p);
            	}
        }
        else if(s.equalsIgnoreCase("change"))
        {String word=variableChange();
         block+=word+"\n";
        }
        else if(s.equalsIgnoreCase("input"))
        {
            block+=voiceInput()+"\n";
        }
        else if(s.equalsIgnoreCase("print")||s.equalsIgnoreCase("display"))
        {block+=voicePrint()+";\n";}
        else if(s.equalsIgnoreCase("structure"))
        {
            block+=voiceStructure()+"\n";
        }
        else if(s.equalsIgnoreCase("function"))
        {
            block+=voiceFunction()+"\n";
        }
        else if(s.equalsIgnoreCase("spell"))
        {String word=alphabetRecognize();
         block+=word+";\n";
        }
    System.out.println("Waiting for Block");    
    //s=scan.next();
    s=voceRecognize();
    }
    int end_index=al.size()-1;
    if(start_index<end_index)
    {
    	for(int i=start_index;i<=end_index;i++)
    	{
    		al.remove(i);
    		i-=1;
    		end_index-=1;
    		
    	}
    }
    return block;
}

public static String variableChange()
{   ArrayList<String>al_copy=al;
	Collections.sort(al_copy);
	
	ArrayList<String> activeList=new ArrayList<String>();
    for(String k:al_copy)
    {
    	System.out.println(k);
    }
    String variable=alphabetRecognize();
    int max=0;
    int min=0;
    
    for(int i=0;i<al_copy.size();i++)
    {
    	if(al_copy.get(i).startsWith(variable))
    	{
    		min=i;
    		max=i;
    		
    	while(max<al_copy.size()&&al_copy.get(max).startsWith(variable))
    	{	
    		activeList.add(al_copy.get(max));
    		max++;
    	}
 
    		
    		break;
    		
    	}
    }
    	Scanner scan=new Scanner(System.in);
    	int start=-1;
    	int size=activeList.size();
    	String s="next";
    	while(!s.equalsIgnoreCase("end"))    	
    	{	
    		if(s.equalsIgnoreCase("next"))
    		{	variable=activeList.get((++start)%activeList.size());
    			System.out.println(prog+"\n"+variable);
    		}
    		else if(s.equalsIgnoreCase("previous"))
    		{
    		if(start==0)
    		{
    			start=size-1;
    		}
    		else
    			{start--;}
    		
    		variable=activeList.get(start%activeList.size());
    		System.out.println(prog+"\n"+variable);
    		//System.out.println(s);
    		}
    		s=voceRecognize();
    		//s=scan.next();

    	}
    variable+=alphabetRecognize();
    
    return variable;
}
public static int getLineNumber()
{
	System.out.println("Waiting for Line number");
	int line_number=Integer.parseInt(numberRecognize("integer"));
	return line_number;
}
public static int getWordNumber()
{
	System.out.println("Waiting for Word number");
	int word_number=Integer.parseInt(numberRecognize("integer"));
	return word_number;
}
public static String voiceEdit()
{System.out.println("edit Mode");
	String edit="";
	//Scanner scan=new Scanner(System.in);
	System.out.println("Waiting for edit commands DELETE FIND REPLACE CUT COPY INSERT");
	String s=voceRecognize();
	while(s.length()==0 &&((!s.equalsIgnoreCase("delete")||!s.equalsIgnoreCase("find")||!s.equalsIgnoreCase("replace")||!s.equalsIgnoreCase("cut")||!s.equalsIgnoreCase("copy")||!s.equalsIgnoreCase("insert"))))
	{	System.out.println("Waiting for edit commands DELETE FIND REPLACE CUT COPY INSERT");
		s=voceRecognize();
	}
	if(s.equalsIgnoreCase("delete"))
	{s=voceRecognize();
	int line_number=0;
	while(s.length()==0 &&((!s.equalsIgnoreCase("line")||s.equalsIgnoreCase("word"))))
	{	System.out.println("Waiting for Delete comands LINE WORD");
		s=voceRecognize();
	}
	if(s.equalsIgnoreCase("line"))
		{line_number=getLineNumber();
		String[] prog_lines=prog.split("\\r?\\n");
		if(line_number<=prog_lines.length)
		{System.out.println("Deleting: "+prog_lines[line_number-1]);
		for(int i=0;i<prog_lines.length;i++)
			{if(i==line_number-1)
			{
				continue;}
			else
			{
			prog=prog_lines[i]+"\n";
			}
			}
			}
		else
		{System.out.println("Line number Exceeded");
	}
	}
	}
	else if(s.equalsIgnoreCase("word"))
	{
		int line_number=getLineNumber();
		int word_number=getWordNumber();
		String line="";
		String [] prog_lines=prog.split("\\r?\\n");
		if(line_number<=prog_lines.length)
		{	line=prog_lines[line_number-1];
			String []line_words=line.split("\\s");
			word_number=getWordNumber();
			line="";
			if(word_number<=line_words.length)
			{
				for(int i=0;i<line_words.length;i++)
				{
					if(i==word_number-1)
					{
						continue;
					}
					else
					{
						line+=line_words[i]+" ";
					}
				}
				for(int i=0;i<prog_lines.length;i++)
				{if(i==line_number-1)
				{prog+=line+"\n";}
				else
				{
				prog+=prog_lines[i]+"\n";
				}
				}
				}
			else
			{
				System.out.println("Word limit exceeded!.");
			}
		}
	}
	else if(s.equalsIgnoreCase("replace"))
	{	System.out.println("Waiting for Replace Commands. SINGLE ALL");
		s=voceRecognize();
		while(s.length()==0 &&((!s.equalsIgnoreCase("single")||s.equalsIgnoreCase("all"))))
		{	
			System.out.println("Waiting for delete commands SINGLE ALL");
			s=voceRecognize();
		}
		if(s.equalsIgnoreCase("single"))
		{
			int line_number=getLineNumber();
			int word_number=getWordNumber();
			String replacement_word="";
			String line="";
			System.out.println("Enter replacement word.");
			replacement_word=alphabetRecognize();
			
			String [] prog_lines=prog.split("\\r?\\n");
			if(line_number<=prog_lines.length)
			{	line=prog_lines[line_number-1];
				String []line_words=line.split("\\s");
				if(word_number<=line_words.length)
				{
					for(int i=0;i<line_words.length;i++)
					{
						if(i==word_number-1)
						{
							line+=replacement_word+" ";
						}
						else
						{
							line+=line_words[i]+" ";
						}
					}
					for(int i=0;i<prog_lines.length;i++)
					{if(i==line_number-1)
					{prog+=line+"\n";}
					else
					{
					prog+=prog_lines[i]+"\n";
					}
					}
					}
				else
				{
					System.out.println("Word limit exceeded!.");
				}
			}
			
		}
		else if(s.equalsIgnoreCase("all"))
		{
			int line_number=getLineNumber();
			int word_number=getWordNumber();
			String replacement_word="";
			String [] prog_lines=prog.split("\\r?\\n");
			String line="";
			System.out.println("Enter replacement word.");
			replacement_word=alphabetRecognize();
			if(line_number<=prog_lines.length)
			{
				line=prog_lines[line_number-1];
				String []line_words=line.split("\\s");
				if(word_number<=line_words.length)
				{
				String word=line_words[word_number-1];
				prog.replaceAll(word,replacement_word);
				}
				else 
				{
					System.out.println("Word Number Limit Reached");
				}
			}
			else
			{
				System.out.println("Line Number Limit Reached");
			}
			
		}
	}
	else if(s.equalsIgnoreCase("copy"))
	{
		System.out.println("Enter the line number where the word is to be copied from");
		int line_number_copy=getLineNumber();
		System.out.println("Enter the word number in the line for copying.");
		int word_number_copy=getWordNumber();
		System.out.println("Enter the line number where the word is to be pasted");
		int line_number_paste=getLineNumber();
		System.out.println("Enter the word number in the line after which the string will be pasted.");
		int word_number_paste=getWordNumber();
		
		String line="";
		String []prog_lines=prog.split("\\r?\\n");
		if(line_number_copy<=prog_lines.length)
		{
			line=prog_lines[line_number_copy-1];
			String []line_words=line.split("\\s");
			line=prog_lines[line_number_paste-1];
			String []line_words_paste=line.split("\\s");
			line="";
			
			if(word_number_copy<=line_words.length&&word_number_paste<=line_words.length)
			{prog="";
			String word=line_words[word_number_copy-1];
			if(word_number_paste==0)
			{
				line=word+prog_lines[line_number_paste-1];
			}
			else
			{
			for(int i=0;i<line_words_paste.length;i++)
			{
				if(i==word_number_paste-1)
				{
					line+=line_words_paste[i]+" "+word;
				}
				else
				{
					line+=line_words_paste[i]+" ";
				}
			}
			}
			for(int i=0;i<prog_lines.length;i++)
			{if(i==line_number_paste-1)
			{prog+=line+"\n";}
			else
			{
			prog+=prog_lines[i]+"\n";
			}
			}
			}
			else 
			{
				System.out.println("Word Number Limit Reached");
			}
		}
		else
		{
			System.out.println("Line Number Limit Reached");
		}
	}
	else if(s.equalsIgnoreCase("cut"))
	{
		System.out.println("Enter the line number where the word is to be copied from");
		int line_number_copy=getLineNumber();
		System.out.println("Enter the word number in the line for copying.");
		int word_number_copy=getWordNumber();
		System.out.println("Enter the line number where the word is to be pasted");
		int line_number_paste=getLineNumber();
		System.out.println("Enter the word number in the line after which the string will be pasted.");
		int word_number_paste=getWordNumber();
		
		String line="";
		String []prog_lines=prog.split("\\r?\\n");
		if(line_number_copy<=prog_lines.length&&line_number_paste<=prog_lines.length)
		{
			line=prog_lines[line_number_copy-1];
			String []line_copy_words=line.split("\\s");
			line=prog_lines[line_number_paste-1];
			String []line_paste_words=line.split("\\s");
			line="";
			String line_paste="";
			if(word_number_copy<=line_copy_words.length && word_number_paste<=line_paste_words.length)
			{prog="";
			String word=line_copy_words[word_number_copy-1];
			for(int i=0;i<line_copy_words.length;i++)
			{	if(i==word_number_copy-1)
				{
				 continue;
				}
				else
				{
					line+=line_copy_words[i]+" ";
				}
			}
			if(word_number_paste==0)
			{
				line_paste=word+prog_lines[line_number_paste-1];
			}
			else
			{
			for(int i=0;i<line_paste_words.length;i++)
			{if(i==word_number_paste-1)
				{
					line_paste+=line_copy_words[i]+" "+word;
				}
				else
				{
					line_paste+=line_copy_words[i]+" ";
				}
			}
			}
			
			for(int i=0;i<prog_lines.length;i++)
			{if(i==line_number_paste-1)
			{prog+=line_paste+"\n";}
			else if(i==line_number_copy-1)
			{
				prog+=line+"\n";
			}
			else
			{
			prog+=prog_lines[i]+"\n";
			}
			}
			}
			else 
			{
				System.out.println("Word Number Limit Reached");
			}
			
		
		}
		else
		{
			System.out.println("Line Number Limit Reached");
		}
	}
	else if(s.equalsIgnoreCase("insert"))
	{int line_number=getLineNumber();
	int word_number=getWordNumber();
	String [] prog_lines=prog.split("\\r?\\n");
	String line="";
		if(line_number<=prog_lines.length)
		{
			line=prog_lines[line_number-1];
			String []line_words=line.split("\\s");
			line="";
			if(word_number<=line_words.length)
			{
			System.out.println("Speak the word to be inserted.");
			String insert_word=alphabetRecognize();
			if(word_number==0)
			{
				line=insert_word+prog_lines[line_number-1];
			}
			else
			{
			for(int i=0;i<line_words.length;i++)
			{
				if(i==word_number-1)
				{
					line+=line_words[i]+insert_word;
				}
				else
				{
					line+=line_words[i]+" ";
				}
			}
			}
			prog="";
			for(int i=0;i<prog_lines.length;i++)
			{if(i==line_number-1)
			{prog+=line+"\n";}
			else
			{
			prog+=prog_lines[i]+"\n";
			}
			}
			}
			else
			{
				System.out.println("Word Number Limit Reacher");
			}
		}
		else
		{
			System.out.println("Line Number Limit Reached");
		}
	}
	else if(s.equalsIgnoreCase("end"))
	{
		
	}
	return prog;
}


public static void voicePause()
{String s=voceRecognize();
	{System.out.println("Pausing");
	while(!s.equalsIgnoreCase("start"))
	{s=voceRecognize();
	 System.out.println("Paused! "+s);
	}
	System.out.println("Starting!");}
	
}
    public static String voceRecognize()
    {	String s=voce.SpeechInterface.popRecognizedString();
    	if(s.length()>0)
    	{
        System.out.println("Voce Recognized: "+s);
    	}
    	return s;
    }
    public static void main(String args[])
    {
//    {   Desktop dt = Desktop.getDesktop();
//    try {
//        dt.open( new File("FileName.csv") );
//    } catch (IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    } 
        String word="";
        
//}	
        
        voce.SpeechInterface.init("C:/Users/Sri/Desktop/voce-0.9.1/voce-0.9.1/lib", false, true, 
		"file:C:/Users/Sri/Desktop/voce-0.9.1/voce-0.9.1/lib/gram", "speech");
        voce.SpeechInterface.setRecognizerEnabled(true);
        //System.exit(0);
        TextEditor f=new TextEditor();
        voicePause();
       
        //String [] keywords={ "int","float","char","double"};
        Scanner scan=new Scanner(System.in);
        String s="";
        while(!s.equalsIgnoreCase("finish"))
        {word="";
        boolean declare=false;
        boolean edit=false;
        System.out.println("Main Mode");
        //s=scan.next();
        s=voceRecognize();
        if(s.equals("declare"))
        {declare=true;
        do
        {word=voiceDeclare(true);
        prog+=word;
        f.area.setText(f.area.getText()+word);
        //s=scan.next();
        s=voceRecognize();
        while(s.length()==0)
        {	System.out.println("Waiting to continuue declarations or proceed to other part. NEXT to continue.");
        	s=voceRecognize();
        }
        }
        while(s.equals("next"));
        }
        else if(s.equalsIgnoreCase("define")||s.equalsIgnoreCase("macro"))
        {
            word=voiceMacro()+"\n";
            prog+=word;
        }
        
        else if(s.equalsIgnoreCase("include"))
        {
            word=voiceInclude()+"\n";
            prog+=word;
        }
        
        else if(s.equalsIgnoreCase("structure"))
        {   word=voiceStructure()+"\n";
            prog+=word;
        }
        else if(s.equalsIgnoreCase("function"))
        {     word=voiceFunction()+"\n";
            prog+=word;
        }
        else if(s.equalsIgnoreCase("print")||s.equalsIgnoreCase("display"))
        {word=voicePrint()+";\n";
            prog+=word;}
        else if(s.equals("sleep")||s.equals("sleep"))
        {voicePause();}
        

        else if(s.equalsIgnoreCase("character"))
        {word=characterRecognize()+"\n";
         prog+=word;
        }
        else if(s.equalsIgnoreCase("change"))//use only if there is a running list of  variables
        {word=variableChange()+";\n";
        //alphabetRecognize()+"\n";
         prog+=word;
        }
        else if(s.equalsIgnoreCase("control"))
        {word=voiceControlStructures()+"\n";
         prog+=word;
        }
        else if(s.equalsIgnoreCase("input"))
        {    word=voiceInput()+"\n";
            prog+=word;
        }
        else if(s.equalsIgnoreCase("edit"))
        {	edit=true;
        	prog=voiceEdit();
        	  f.area.setText(prog);
        	
        }
        
        else if(s.equalsIgnoreCase("spell"))
        {word=alphabetRecognize();
         prog+=word+"\n";
        }
        
        if(!declare&&!edit)
        {f.area.setText(f.area.getText()+word);
        }
        System.out.println(prog);
        }
        ////System.out.println(prog.contains("stdio"));
        //prog=prog.replace("stdio","string");
        System.out.println(prog);
        scan.close();
        
       


}
}