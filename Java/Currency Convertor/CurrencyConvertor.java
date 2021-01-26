import java.util.Scanner;

public class CurrencyConverter4
{
    // number of currencies
    public static final int NUM_CURRENCIES      = 6;
    // constants to define currencies
    public static final int US_DOLLAR           = 0;
    public static final int BRITISH_POUND       = 1;
    public static final int EURO                = 2;
    public static final int JAPANESE_YEN        = 3;
    public static final int SINGAPORE_DOLLAR    = 4;
    public static final int CHINESE_YUAN        = 5;
    // conversion rates from US dollars to the other five currencies
    public static final float USD_TO_BRITISH_POUND      = 0.630f;
    public static final float USD_TO_EURO               = 0.744f;
    public static final float USD_TO_JAPANESE_YEN       = 82.996f;
    public static final float USD_TO_SINGAPORE_DOLLAR   = 1.289f;
    public static final float USD_TO_CHINESE_YUAN       = 6.584f;

    // function converts money to/from various currencies
    public void convertMoney()
    {
        Scanner input = new Scanner(System.in);
        String choice;
        do
        {
            System.out.println("What is your starting currency?");
            printCurrencies();
            int fromCurrency = input.nextInt();
            if (isValidCurrency(fromCurrency))
            {
                System.out.printf("Enter the amount of %s to convert: ",
                    getCurrencyText(fromCurrency));
                float fromAmount = input.nextFloat();
                if (fromAmount >= 0.f)
                {
                    System.out.println("What currency do you want to convert to? ");
                    printCurrencies();
                    int toCurrency = input.nextInt();
                    if (isValidCurrency(toCurrency))
                    {
                        float toCurrencyAmnt = convertCurrency(fromAmount,
                            fromCurrency, toCurrency);
                        printConversionStatement(fromAmount, fromCurrency,
                            toCurrencyAmnt, toCurrency);
                    }
                    else
                    {
                        System.out.printf("ERROR: invalid currency! (%d)\n",
                            toCurrency);
                    }
                }
                else
                {
                    System.out.printf("ERROR: invalid monetary amount! (%1.2f)\n",
                        fromAmount);
                }
            }
            else
            {
                System.out.printf("ERROR: invalid currency! (%d)\n",
                    fromCurrency);
            }
            System.out.print("Would you like to convert again? (y/n) ");
            choice = input.next();
        }
        while (choice.equalsIgnoreCase("y"));
        System.out.println("Good-bye!");
    }
    
    // print out the currency options
    public void printCurrencies()
    {
        System.out.printf("(%d) US Dollars\n", US_DOLLAR);
        System.out.printf("(%d) British Pounds\n", BRITISH_POUND);
        System.out.printf("(%d) Euros\n", EURO);
        System.out.printf("(%d) Japanese Yen\n", JAPANESE_YEN);
        System.out.printf("(%d) Singapore Dollars\n", SINGAPORE_DOLLAR);
        System.out.printf("(%d) Chinese Yuan\n", CHINESE_YUAN);
    }
    
    // print a statement about the currency conversion
    public void printConversionStatement(float amount1, int currency1,
        float amount2, int currency2)
    {
        System.out.printf("%1.2f %s is equal to %1.2f %s.\n",
            amount1, getCurrencyText(currency1),
            amount2, getCurrencyText(currency2));
    }
    
    // retrieve the string equivalent of each currency
    public String getCurrencyText(int currency)
    {
        switch (currency)
        {
            case US_DOLLAR:
                return "US Dollars";
            case BRITISH_POUND:
                return "British Pounds";
            case EURO:
                return "Euros";
            case JAPANESE_YEN:
                return "Japanense Yen";
            case SINGAPORE_DOLLAR:
                return "Singapore Dollars";
            case CHINESE_YUAN:
                return "Chinese Yuan";
            default:
                return null;
        }
    }
    
    // returns true if the integer represents a valid currency, false otherwise
    public boolean isValidCurrency(int currency)
    {
        return 0 <= currency && currency < NUM_CURRENCIES;
    }
    
    // converts and returns the value of usd in another currency
    public float usdToOtherCurrency(float usd, int otherCurrency)
    {
        switch (otherCurrency)
        {
            case US_DOLLAR:
                return usd;
            case BRITISH_POUND:
                return usd * USD_TO_BRITISH_POUND;
            case EURO:
                return usd * USD_TO_EURO;
            case JAPANESE_YEN:
                return usd * USD_TO_JAPANESE_YEN;
            case SINGAPORE_DOLLAR:
                return usd * USD_TO_SINGAPORE_DOLLAR;
            case CHINESE_YUAN:
                return usd * USD_TO_CHINESE_YUAN;
            default:
                return -1.f;
        }
    }
    
    // converts and returns the amount of US doloars in the given other currency
    public float otherCurrencyToUSD(float amount, int otherCurrency)
    {
        switch (otherCurrency)
        {
            case US_DOLLAR:
                return amount;
            case BRITISH_POUND:
                return amount / USD_TO_BRITISH_POUND;
            case EURO:
                return amount / USD_TO_EURO;
            case JAPANESE_YEN:
                return amount / USD_TO_JAPANESE_YEN;
            case SINGAPORE_DOLLAR:
                return amount / USD_TO_SINGAPORE_DOLLAR;
            case CHINESE_YUAN:
                return amount / USD_TO_CHINESE_YUAN;
            default:
                return -1.f;
        }
    }
    
    // convert between any two currencies
    public float convertCurrency(float fromAmount, int fromCurrency,
        int toCurrency)
    {
        // convert fromCurrency to USD
        float usd = otherCurrencyToUSD(fromAmount, fromCurrency);
        // convert USD to toCurrency
        float toAmount = usdToOtherCurrency(usd, toCurrency);
        // return amount
        return toAmount;
    }
    
    // main method
    public static void main(String[] args)
    {
        CurrencyConverter4 converter = new CurrencyConverter4();
        converter.convertMoney();
    }
}