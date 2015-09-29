package leetcode;


public class BestTimeToBuyAndSellStocks {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int solution = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            solution = Math.max(prices[i] - min, solution);
        }
        
        return solution;
        
    }

}
