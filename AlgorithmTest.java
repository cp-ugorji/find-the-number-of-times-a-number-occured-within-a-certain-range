
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chux
 */
public class AlgorithmTest {
    
    static int numberofKsbtw0andN(int nnumberRange, int numberToCheck)
    {
	int originalNum = nnumberRange;
	int power = 1;
	int i = 0;
	int counter = 0;
	
	while (nnumberRange > 0)
        {
            int d = nnumberRange % 10;
            nnumberRange /= 10;
            counter += d * (power * i) / 10;
            if(d > numberToCheck)
            {
                counter += power;
            }
            else if (d == numberToCheck)
            {
                 counter += originalNum % power + 1;
            }
            power *= 10;
            i++;
        }
	return counter;
    }
    
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedReader br = null;
        int lineCount = 0;
        int numberToCheck = 0;
        int nnumberRange = 0;
        
        try
        {
            fis = new FileInputStream("C:\\Users\\Chux\\Desktop\\globalskillTest.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            
            
            String line = br.readLine();
            OUTER:
            while (line != null) {
                System.out.println("Line = " + line);
                
                lineCount += 1;
                System.out.println("LineCount = " + lineCount);
                switch (lineCount) {
                    case 1:
                        numberToCheck = Integer.parseInt(line);
                        System.out.println("numberToCheck = " + numberToCheck);
                        break;
                    case 2:
                        line = br.readLine();
                        nnumberRange = Integer.parseInt(line);
                        System.out.println("nnumberRange = " + nnumberRange);
                        break;
                    default:
                        break OUTER;
                }
            }
            
            if(nnumberRange!= 0 && numberToCheck != 0)
            {
                System.out.println("Result = " + numberofKsbtw0andN(nnumberRange, numberToCheck));
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
}
