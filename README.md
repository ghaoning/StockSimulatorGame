# StockSimulatorGame

This is a Java project to run the stock simulator game.

## Goal

The goal of this game to make a great fortune via stock transactions.

## User Interaction

At the very beginning, the user will be given *$1,000,000* to play the game.

User can play the game in following steps:

1. View the overall information about stocks in the market in aspects of
  - **Risk-free rate**: Rate of return of the government bond, usually ranging from 1% to 3.5%.
  - **Beta**: An indicator of the market risk of a firm, usually ranging from 0 to 3.
  - **Market Premium**: Extra return from the risk-free asset in the market, usually ranging from 3% to 10%.
  - **Idiosyncratic Premium**: Firm-specific risk associated with return, usually ranging from -30% to 30%.
  - **Country Premium**: Country-specific risk associated with return, usually ranging from 0% to 5%.
  Based on those 5 parameters, the stock value will be calculated.
2. Determine whether to sell or buy a stock
3. Input the information about the transaction

After *10* rounds of game, the final points will be calculated via adding user's current deposit and current stock value.

## Class

1. User: Define the user's characteristics including deposit and owned stocks.
2. Stock: Stock for a specific company, with all parameters related.
3. Market: A market consisting of 5 stocks.
4. Game: Define the user interactions during the game.
5. GameRunner: Launcher of the game.
