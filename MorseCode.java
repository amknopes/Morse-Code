/* 
 * @author: Athena Knopes
 *  period: 1
 *
 *  directions: complete the methods below. the lab should be case insensitive
 */

import java.util.TreeMap;
import java.util.*;
public class MorseCode
{
  private static final char DOT = '.';
  private static final char DASH = '-';

  private static TreeMap<Character, String> codeMap;
  private static TreeNode decodeTree;

  // this method is complete
  public static void start()
  {
    codeMap = new TreeMap<Character, String>();
    decodeTree = new TreeNode(new Character(' '), null, null);
          // put a space in the root of the decoding tree

    addSymbol('A', ".-");
    addSymbol('B', "-...");
    addSymbol('C', "-.-.");
    addSymbol('D', "-..");
    addSymbol('E', ".");
    addSymbol('F', "..-.");
    addSymbol('G', "--.");
    addSymbol('H', "....");
    addSymbol('I', "..");
    addSymbol('J', ".---");
    addSymbol('K', "-.-");
    addSymbol('L', ".-..");
    addSymbol('M', "--");
    addSymbol('N', "-.");
    addSymbol('O', "---");
    addSymbol('P', ".--.");
    addSymbol('Q', "--.-");
    addSymbol('R', ".-.");
    addSymbol('S', "...");
    addSymbol('T', "-");
    addSymbol('U', "..-");
    addSymbol('V', "...-");
    addSymbol('W', ".--");
    addSymbol('X', "-..-");
    addSymbol('Y', "-.--");
    addSymbol('Z', "--..");
    addSymbol('0', "-----");
    addSymbol('1', ".----");
    addSymbol('2', "..---");
    addSymbol('3', "...--");
    addSymbol('4', "....-");
    addSymbol('5', ".....");
    addSymbol('6', "-....");
    addSymbol('7', "--...");
    addSymbol('8', "---..");
    addSymbol('9', "----.");
    addSymbol('.', ".-.-.-");
    addSymbol(',', "--..--");
    addSymbol('?', "..--..");
  }

  /**
   *  Inserts a letter and its Morse code string into the encoding map (codeMap)
   *  and calls treeInsert to insert them into the decoding tree.
   */
  private static void addSymbol(char letter, String code)
  {
      codeMap.put(letter, code);
      treeInsert(letter, code);
  }

  /**
   *  Inserts a letter according to its Morse code string into the 
   *  decoding tree.  Each dot-dash string corresponds to a path
   *  in the tree from the root to a node: at a "dot" go left, at a "dash" go
   *  right.  The node at the end of the path holds the symbol
   *  for that code string.  See the word documents for more help.
   */
  private static void treeInsert(char letter, String code)
  {
      TreeNode node=decodeTree;
      for(int x=0; x<code.length(); x++)
      {
          char temp=code.charAt(x);
          if(temp==DOT)
          {
              if (node.getLeft() == null)
                  node.setLeft(new TreeNode(node.getValue()+(DOT+""), null, null));
              node=node.getLeft();
          }
          else if(temp==DASH)
          {
              if (node.getRight() == null)
                  node.setRight(new TreeNode(node.getValue()+(DASH+""), null, null));
              node=node.getRight();
          }
      }
      node.setValue(letter);
  }

 /**
  *   Converts text into a Morse code message.  Adds a space after a dot-dash
  *   sequence for each letter.  Other spaces in the text are transferred directly
  *   into the encoded message.
  *   Returns the encoded message.
  */
  public static String encode(String text)
  {
    String ans="";
    for(int x=0; x<text.length(); x++)
    {
        if(text.charAt(x)==' ')
            ans+=" ";
        else
            ans+=codeMap.get(text.charAt(x))+" ";
    }
    return ans;
  }

 /**
  *   Converts a Morse code message into a text string.  Assumes that dot-dash
  *   sequences for each letter are separated by one space.  Additional spaces are
  *   transferred directly into text.
  *   Returns the plain text message.
  */
  public static String decode(String morse)
  {
    String text="";
    int placeHolder=0;
    for(int x=0; x<morse.length(); x++)
    {
        if(x>0 && morse.charAt(x)==' ' && morse.charAt(x-1)!=' ')
        {
            Iterator<Character> it=codeMap.keySet().iterator();
            while(it.hasNext())
            {
                char c=it.next();
                if(codeMap.get(c).equals(morse.substring(placeHolder,x)))
                    text+= c + "";
            }
            placeHolder=x+1;
        }
        else if(x>0 && morse.charAt(x-1)==' '&& morse.charAt(x)==' ')
        {
            text+=" ";
            placeHolder=x+1;
        }
    }
    return text;
  }
}