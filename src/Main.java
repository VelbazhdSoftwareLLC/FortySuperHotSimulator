
/*==============================================================================
* 40 Super Hot Slot Simulation version 0.0.1                                   *
* Copyrights (C) 2017 Velbazhd Software LLC                                    *
*                                                                              *
* developed by Todor Balabanov ( todor.balabanov@gmail.com )                   *
* Sofia, Bulgaria                                                              *
*                                                                              *
* This program is free software: you can redistribute it and/or modify         *
* it under the terms of the GNU General Public License as published by         *
* the Free Software Foundation, either version 3 of the License, or            *
* (at your option) any later version.                                          *
*                                                                              *
* This program is distributed in the hope that it will be useful,              *
* but WITHOUT ANY WARRANTY; without even the implied warranty of               *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                *
* GNU General Public License for more details.                                 *
*                                                                              *
* You should have received a copy of the GNU General Public License            *
* along with this program. If not, see <http://www.gnu.org/licenses/>.         *
*                                                                              *
==============================================================================*/

import java.util.Random;

/**
 * Application single entry point class.
 * 
 * @author Todor Balabanov
 */
public class Main {

	/**
	 * Pseudo-random number generator.
	 */
	private static final Random PRNG = new Random();

	/**
	 * List of symbols names.
	 */
	private static String[] symbolsNames = {

			"STAR       ",

			"SEVEN      ",

			"GRAPE      ",

			"WATERMELON ",

			"PLUM       ",

			"LEMON      ",

			"ORANGE     ",

			"CHERRY     ",

			"           ",

			"           ",

			"           ",

			"           ",

			"           ",
			
	};

	/**
	 * Slot game pay table.
	 */
	private static int[][] paytable = {

			new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new int[] { 200, 40, 20, 20, 20, 10, 10, 10, 0, 0, 0, 0, 0 },

			new int[] { 800, 400, 80, 40, 40, 20, 20, 20, 0, 0, 0, 0, 0 },

			new int[] { 20000, 1000, 400, 200, 200, 100, 100, 100, 0, 0, 0, 0, 0 },

	};

	/**
	 * Lines combinations.
	 */
	private static int[][] lines = {

			new int[] { 0, 0, 0, 0, 0 },

			new int[] { 1, 1, 1, 1, 1 },

			new int[] { 2, 2, 2, 2, 2 },

			new int[] { 3, 3, 3, 3, 3 },

			new int[] { 2, 1, 0, 1, 2 },

			new int[] { 1, 2, 3, 2, 1 },

			new int[] { 0, 0, 1, 2, 3 },

			new int[] { 3, 3, 2, 1, 0 },

			new int[] { 1, 0, 0, 0, 1 },

			new int[] { 2, 3, 3, 3, 2 },

			new int[] { 0, 1, 2, 3, 3 },

			new int[] { 3, 2, 1, 0, 0 },

			new int[] { 1, 0, 1, 2, 1 },

			new int[] { 2, 3, 2, 1, 2 },

			new int[] { 0, 1, 0, 1, 0 },

			new int[] { 3, 2, 3, 2, 3 },

			new int[] { 1, 2, 1, 0, 1 },

			new int[] { 2, 1, 2, 3, 2 },

			new int[] { 0, 1, 1, 1, 0 },

			new int[] { 3, 2, 2, 2, 3 },

			new int[] { 1, 1, 2, 3, 3 },

			new int[] { 2, 2, 1, 0, 0 },

			new int[] { 0, 1, 2, 2, 3 },

			new int[] { 3, 2, 1, 1, 0 },

			new int[] { 1, 2, 2, 2, 3 },

			new int[] { 2, 1, 1, 1, 0 },

			new int[] { 0, 0, 1, 0, 0 },

			new int[] { 3, 3, 2, 3, 3 },

			new int[] { 1, 1, 0, 1, 1 },

			new int[] { 2, 2, 3, 2, 2 },

			new int[] { 0, 0, 0, 1, 2 },

			new int[] { 3, 3, 3, 2, 1 },

			new int[] { 1, 0, 0, 1, 2 },

			new int[] { 2, 3, 3, 2, 1 },

			new int[] { 0, 1, 1, 2, 3 },

			new int[] { 3, 2, 2, 1, 0 },

			new int[] { 1, 0, 1, 2, 3 },

			new int[] { 2, 3, 2, 1, 0 },

			new int[] { 0, 1, 2, 3, 2 },

			new int[] { 3, 2, 1, 0, 1 },

	};

	/**
	 * Stips in the base game as symbols names.
	 */
	private static String[][] baseReelsAsSymbols = {

			new String[] { "SEVEN", "SEVEN", "SEVEN", "SEVEN", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "CHERRY",
					"CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", "WATERMELON", "WATERMELON",
					"WATERMELON", "WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE",
					"ORANGE", "ORANGE", "ORANGE", "ORANGE", "STAR", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "PLUM",
					"PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "LEMON", "LEMON", "LEMON", "LEMON",
					"GRAPE", "GRAPE", "GRAPE", "GRAPE", "STAR", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "GRAPE",
					"GRAPE", "GRAPE", "GRAPE", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM",
					"WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "PLUM",
					"PLUM", "PLUM", "PLUM", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"LEMON", "LEMON", "LEMON", "LEMON", },

			new String[] { "SEVEN", "SEVEN", "SEVEN", "SEVEN", "LEMON", "LEMON", "LEMON", "LEMON", "CHERRY", "CHERRY",
					"CHERRY", "CHERRY", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "PLUM", "PLUM", "PLUM", "PLUM", "LEMON", "LEMON", "LEMON", "LEMON", "PLUM", "PLUM",
					"PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "GRAPE", "GRAPE", "GRAPE", "GRAPE",
					"ORANGE", "ORANGE", "ORANGE", "ORANGE", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE",
					"ORANGE", "ORANGE", "STAR", "PLUM", "PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"STAR", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "PLUM",
					"PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "WATERMELON", "WATERMELON",
					"WATERMELON", "WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE", "ORANGE",
					"ORANGE", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "PLUM", "PLUM", "PLUM", "PLUM",
					"LEMON", "LEMON", "LEMON", "LEMON", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "STAR",
					"ORANGE", "ORANGE", "ORANGE", "ORANGE", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "WATERMELON",
					"WATERMELON", "WATERMELON", "WATERMELON", },

			new String[] { "SEVEN", "SEVEN", "SEVEN", "SEVEN", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON",
					"LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "LEMON", "LEMON", "LEMON",
					"LEMON", "STAR", "PLUM", "PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY",
					"WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"GRAPE", "GRAPE", "GRAPE", "GRAPE", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "PLUM", "PLUM", "PLUM",
					"PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "PLUM",
					"PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "STAR", "WATERMELON", "WATERMELON",
					"WATERMELON", "WATERMELON", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "LEMON", "LEMON", "LEMON",
					"LEMON", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", "LEMON", "LEMON",
					"LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"STAR", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "PLUM", "PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY",
					"CHERRY", "CHERRY", "LEMON", "LEMON", "LEMON", "LEMON", "PLUM", "PLUM", "PLUM", "PLUM", "CHERRY",
					"CHERRY", "CHERRY", "CHERRY", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "CHERRY", "CHERRY", "CHERRY",
					"CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", },

			new String[] { "SEVEN", "SEVEN", "SEVEN", "SEVEN", "LEMON", "LEMON", "LEMON", "LEMON", "WATERMELON",
					"WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "LEMON", "LEMON",
					"LEMON", "LEMON", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "GRAPE", "GRAPE", "GRAPE", "GRAPE",
					"ORANGE", "ORANGE", "ORANGE", "ORANGE", "LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE",
					"GRAPE", "GRAPE", "PLUM", "PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "STAR",
					"LEMON", "LEMON", "LEMON", "LEMON", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "GRAPE", "GRAPE",
					"GRAPE", "GRAPE", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE",
					"ORANGE", "ORANGE", "LEMON", "LEMON", "LEMON", "LEMON", "STAR", "CHERRY", "CHERRY", "CHERRY",
					"CHERRY", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "LEMON", "LEMON", "LEMON", "LEMON", "GRAPE",
					"GRAPE", "GRAPE", "GRAPE", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "PLUM", "PLUM",
					"PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "PLUM", "PLUM", "PLUM",
					"PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "PLUM", "PLUM",
					"PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "PLUM", "PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "PLUM",
					"PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "LEMON", "LEMON", "LEMON", "LEMON",
					"WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON",
					"WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "CHERRY", "CHERRY", "CHERRY", "CHERRY",
					"GRAPE", "GRAPE", "GRAPE", "GRAPE", "PLUM", "PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE",
					"ORANGE", },

			new String[] { "SEVEN", "SEVEN", "SEVEN", "SEVEN", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "WATERMELON",
					"WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "GRAPE", "GRAPE",
					"GRAPE", "GRAPE", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", "LEMON",
					"LEMON", "LEMON", "LEMON", "SEVEN", "SEVEN", "SEVEN", "SEVEN", "ORANGE", "ORANGE", "ORANGE",
					"ORANGE", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE", "ORANGE",
					"ORANGE", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "LEMON",
					"LEMON", "LEMON", "LEMON", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM",
					"STAR", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "LEMON", "LEMON", "LEMON", "LEMON", "CHERRY",
					"CHERRY", "CHERRY", "CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", "CHERRY", "CHERRY", "CHERRY",
					"CHERRY", "PLUM", "PLUM", "PLUM", "PLUM", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "CHERRY",
					"CHERRY", "CHERRY", "CHERRY", "WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "LEMON",
					"LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE", "GRAPE", "GRAPE", "ORANGE", "ORANGE", "ORANGE",
					"ORANGE", "LEMON", "LEMON", "LEMON", "LEMON", "WATERMELON", "WATERMELON", "WATERMELON",
					"WATERMELON", "LEMON", "LEMON", "LEMON", "LEMON", "ORANGE", "ORANGE", "ORANGE", "ORANGE", "GRAPE",
					"GRAPE", "GRAPE", "GRAPE", "CHERRY", "CHERRY", "CHERRY", "CHERRY", "STAR", "ORANGE", "ORANGE",
					"ORANGE", "ORANGE", "PLUM", "PLUM", "PLUM", "PLUM", "STAR", "CHERRY", "CHERRY", "CHERRY", "CHERRY",
					"WATERMELON", "WATERMELON", "WATERMELON", "WATERMELON", "ORANGE", "ORANGE", "ORANGE", "ORANGE",
					"PLUM", "PLUM", "PLUM", "PLUM", "PLUM", "LEMON", "LEMON", "LEMON", "LEMON", "GRAPE", "GRAPE",
					"GRAPE", "GRAPE", },

	};

	/**
	 * Stips in base game.
	 */
	private static int[][] baseReels = { {} };

	/**
	 * Stips in free spins.
	 */
	private static int[][] freeReels = { {} };

	/**
	 * Use reels stops in brute force combinations generation.
	 */
	private static int[] reelsStops = new int[] { 0, 0, 0, 0, 0 };

	/**
	 * Current visible symbols on the screen.
	 */
	private static int[][] view = {

			new int[] { -1, -1, -1, -1, },

			new int[] { -1, -1, -1, -1, },

			new int[] { -1, -1, -1, -1, },

			new int[] { -1, -1, -1, -1, },

			new int[] { -1, -1, -1, -1, }

	};

	/**
	 * Current free spins multiplier.
	 */
	private static int freeGamesMultiplier = 0;

	/**
	 * If wild is presented in the line multiplier.
	 */
	private static int wildInLineMultiplier = 0;

	/**
	 * If scatter win is presented on the screen.
	 */
	private static int scatterMultiplier = 1;

	/**
	 * Total bet in single base game spin.
	 */
	private static int singleLineBet = 1;

	/**
	 * Total bet in single base game spin.
	 */
	private static int totalBet = singleLineBet * lines.length;

	/**
	 * Free spins to be played.
	 */
	private static int freeGamesNumber = 0;

	/**
	 * Total amount of won money.
	 */
	private static long wonMoney = 0L;

	/**
	 * Total amount of lost money.
	 */
	private static long lostMoney = 0L;

	/**
	 * Total amount of won money in base game.
	 */
	private static long baseMoney = 0L;

	/**
	 * Total amount of won money in free spins.
	 */
	private static long freeMoney = 0L;

	/**
	 * Max amount of won money in base game.
	 */
	private static long baseMaxWin = 0L;

	/**
	 * Max amount of won money in free spins.
	 */
	private static long freeMaxWin = 0L;

	/**
	 * Total number of base games played.
	 */
	private static long totalNumberOfGames = 0L;

	/**
	 * Total number of free spins played.
	 */
	private static long totalNumberOfFreeGames = 0L;

	/**
	 * Total number of free spins started.
	 */
	private static long totalNumberOfFreeGameStarts = 0L;

	/**
	 * Total number of free spins started.
	 */
	private static long totalNumberOfFreeGameRestarts = 0L;

	/**
	 * Hit rate of wins in base game.
	 */
	private static long baseGameHitRate = 0L;

	/**
	 * Hit rate of wins in free spins.
	 */
	private static long freeGamesHitRate = 0L;

	/**
	 * Verbose output flag.
	 */
	private static boolean verboseOutput = false;

	/**
	 * Free spins flag.
	 */
	private static boolean freeOff = false;

	/**
	 * Wild substitution flag.
	 */
	private static boolean wildsOff = false;

	/**
	 * Brute force all winning combinations in base game only flag.
	 */
	private static boolean bruteForce = false;

	/**
	 * Symbols win hit rate in base game.
	 */
	private static long[][] baseSymbolMoney = {

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	};

	/**
	 * Symbols hit rate in base game.
	 */
	private static long[][] baseGameSymbolsHitRate = {

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	};

	/**
	 * Symbols win hit rate in base game.
	 */
	private static long[][] freeSymbolMoney = {

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	};

	/**
	 * Symbols hit rate in base game.
	 */
	private static long[][] freeGameSymbolsHitRate = {

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	};

	/*
	 * Static data initializer.
	 */
	static {
		/*
		 * Transform symbols names to integer values.
		 */
		baseReels = new int[baseReelsAsSymbols.length][];
		for (int i = 0; i < baseReelsAsSymbols.length; i++) {
			baseReels[i] = new int[baseReelsAsSymbols[i].length];
			for (int j = 0; j < baseReelsAsSymbols[i].length; j++) {
				for (int s = 0; s < symbolsNames.length; s++) {
					if (symbolsNames[s].trim().equals(baseReelsAsSymbols[i][j].trim()) == true) {
						baseReels[i][j] = s;
						break;
					}
				}
			}
		}
	}

	/**
	 * Single reels spin to fill view with symbols.
	 *
	 * @param reels
	 *            Reels strips.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 06 Sep 2017
	 */
	private static void nextCombination(int[] reelsStops) {
		reelsStops[0] += 1;
		for (int i = 0; i < reelsStops.length; i++) {
			if (reelsStops[i] >= baseReels[i].length) {
				reelsStops[i] = 0;
				if (i < reelsStops.length - 1) {
					reelsStops[i + 1] += 1;
				}
			}
		}
	}

	/**
	 * Single reels spin to fill view with symbols.
	 *
	 * @param reels
	 *            Reels strips.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void spin(int[][] reels) {
		for (int i = 0, b, a, c, d; i < view.length && i < reels.length; i++) {
			if (bruteForce == true) {
				a = reelsStops[i];
				b = a + 1;
				c = a + 2;
				d = a + 3;
			} else {
				a = PRNG.nextInt(reels[i].length);
				b = a + 1;
				c = a + 2;
				d = a + 3;
			}

			b = b % reels[i].length;
			c = c % reels[i].length;
			d = d % reels[i].length;

			view[i][0] = reels[i][a];
			view[i][1] = reels[i][b];
			view[i][2] = reels[i][c];
			view[i][3] = reels[i][d];
		}
	}

	/**
	 * Calculate win in particular line.
	 *
	 * @param line
	 *            Single line.
	 *
	 * @return Calculated win.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static int[] wildLineWin(int[] line) {
		int[] values = { 1, 0, 0 };

		/*
		 * If there is no leading wild there is no wild win.
		 */
		if (line[0] != values[0]) {
			return (values);
		}

		/*
		 * Wild symbol passing to find first regular symbol.
		 */
		for (int i = 0; i < line.length; i++) {
			/*
			 * First no wild symbol found.
			 */
			if (line[i] != values[0]) {
				break;
			}

			values[1]++;
		}

		values[2] = singleLineBet * paytable[values[1]][values[0]];

		return (values);
	}

	/**
	 * Calculate win in particular line.
	 *
	 * @param line
	 *            Single line.
	 *
	 * @return Calculated win.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static int lineWin(int[] line) {
		int[] wildWin = wildLineWin(line);

		/*
		 * Line win without wild is multiplied by one.
		 */
		wildInLineMultiplier = 1;

		/*
		 * Keep first symbol in the line.
		 */
		int symbol = line[0];

		/*
		 * Wild symbol passing to find first regular symbol.
		 */
		for (int i = 0; i < line.length; i++) {
			/*
			 * First no wild symbol found.
			 */
			if (line[i] != 1) {
				if (line[i] != 0) {
					symbol = line[i];
				}
				break;
			}

			if (line[i] == 0) {
				break;
			}

		}

		/*
		 * Wild symbol substitution. Other wild are artificial they are not part of the
		 * pay table.
		 */
		for (int i = 0; i < line.length && wildsOff == false; i++) {
			if (line[i] == 1) {
				/*
				 * Substitute wild with regular symbol.
				 */
				line[i] = symbol;

				/*
				 * Line win with wild is multiplied by two.
				 */
				wildInLineMultiplier = 1;
			}
		}

		/*
		 * Count symbols in winning line.
		 */
		int number = 0;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == symbol) {
				number++;
			} else {
				break;
			}
		}

		/*
		 * Clear unused symbols.
		 */
		for (int i = number; i < line.length; i++) {
			line[i] = -1;
		}

		int win = singleLineBet * paytable[number][symbol] * wildInLineMultiplier;
		if (win < wildWin[2]) {
			symbol = wildWin[0];
			number = wildWin[1];
			win = wildWin[1];
		}

		if (win > 0 && freeGamesNumber == 0) {
			baseSymbolMoney[number][symbol] += win;
			baseGameSymbolsHitRate[number][symbol]++;
		} else if (win > 0 && freeGamesNumber > 0) {
			freeSymbolMoney[number][symbol] += win * freeGamesMultiplier;
			freeGameSymbolsHitRate[number][symbol]++;
		}

		return (win);
	}

	/**
	 * Calculate win in all possible lines.
	 *
	 * @param view
	 *            Symbols visible in screen view.
	 *
	 * @return Calculated win.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static int linesWin(int[][] view) {
		int win = 0;

		/*
		 * Check wins in all possible lines.
		 */
		for (int l = 0; l < lines.length; l++) {
			int[] line = { -1, -1, -1, -1, -1 };

			/*
			 * Prepare line for combination check.
			 */
			for (int i = 0; i < line.length; i++) {
				int index = lines[l][i];
				line[i] = view[i][index];
			}

			int result = lineWin(line);

			/*
			 * Accumulate line win.
			 */
			win += result;
		}

		return (win);
	}

	/**
	 * Calculate win from scatters.
	 *
	 * @retur Win from scatters.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static int scatterWin(int[][] view) {
		int numberOfScatters = 0;
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				if (view[i][j] == 0) {
					numberOfScatters++;
				}
			}
		}

		int win = paytable[numberOfScatters][0] * totalBet * scatterMultiplier;

		if (win > 0 && freeGamesNumber == 0) {
			baseSymbolMoney[numberOfScatters][0] += win;
			baseGameSymbolsHitRate[numberOfScatters][0]++;
		} else if (win > 0 && freeGamesNumber > 0) {
			freeSymbolMoney[numberOfScatters][0] += win * freeGamesMultiplier;
			freeGameSymbolsHitRate[numberOfScatters][0]++;
		}

		return (win);
	}

	/**
	 * Setup parameters for free spins mode.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void freeGamesSetup() {
		if (bruteForce == true) {
			return;
		}

		if (freeOff == true) {
			return;
		}

		int numberOfScatters = 0;
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				if (view[i][j] == 0) {
					numberOfScatters++;
				}
			}
		}

		/*
		 * In base game 3+ scatters turn into free spins.
		 */
		if (numberOfScatters < 3 && freeGamesNumber == 0) {
			return;
		} else if (numberOfScatters >= 3 && freeGamesNumber == 0) {
			freeGamesNumber = 0;
			freeGamesMultiplier = 0;
			//totalNumberOfFreeGameStarts++;
		} else if (numberOfScatters >= 3 && freeGamesNumber > 0) {
			freeGamesNumber += 0;
			freeGamesMultiplier = 0;
			//totalNumberOfFreeGameRestarts++;
		}
	}

	/**
	 * Play single free spin game.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void singleFreeGame() {
		if (bruteForce == true) {
			return;
		}

		if (freeOff == true) {
			return;
		}

		/*
		 * Spin reels.
		 */
		spin(freeReels);

		/*
		 * Win accumulated by lines.
		 */
		int win = linesWin(view) + scatterWin(view);
		win *= freeGamesMultiplier;

		/*
		 * Add win to the statistics.
		 */
		freeMoney += win;
		wonMoney += win;
		if (freeMaxWin < win) {
			freeMaxWin = win;
		}

		/*
		 * Count free games hit rate.
		 */
		if (win > 0) {
			freeGamesHitRate++;
		}

		/*
		 * Check for free games.
		 */
		freeGamesSetup();
	}

	/**
	 * Play single base game.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void singleBaseGame() {
		/*
		 * Spin reels.
		 */
		spin(baseReels);
		if (bruteForce == true) {
			nextCombination(reelsStops);
		}

		/*
		 * Win accumulated by lines.
		 */
		int win = linesWin(view) + scatterWin(view);

		/*
		 * Add win to the statistics.
		 */
		baseMoney += win;
		wonMoney += win;
		if (baseMaxWin < win) {
			baseMaxWin = win;
		}

		/*
		 * Count base game hit rate.
		 */
		if (win > 0) {
			baseGameHitRate++;
		}

		/*
		 * Check for free games.
		 */
		freeGamesSetup();

		/*
		 * Play all free games.
		 */
		while (freeGamesNumber > 0) {
			totalNumberOfFreeGames++;

			singleFreeGame();

			freeGamesNumber--;
		}
		freeGamesMultiplier = 1;
	}

	/**
	 * Print help information.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void printHelp() {
		System.out.println("*******************************************************************************");
		System.out.println("* 40 Super Hot Slot Simulation version 0.0.1                                  *");
		System.out.println("* Copyrights (C) 2017 Velbazhd Software LLC                                   *");
		System.out.println("*                                                                             *");
		System.out.println("* developed by Todor Balabanov ( todor.balabanov@gmail.com )                  *");
		System.out.println("* Sofia, Bulgaria                                                             *");
		System.out.println("*                                                                             *");
		System.out.println("* This program is free software: you can redistribute it and/or modify        *");
		System.out.println("* it under the terms of the GNU General Public License as published by        *");
		System.out.println("* the Free Software Foundation, either version 3 of the License, or           *");
		System.out.println("* (at your option) any later version.                                         *");
		System.out.println("*                                                                             *");
		System.out.println("* This program is distributed in the hope that it will be useful,             *");
		System.out.println("* but WITHOUT ANY WARRANTY; without even the implied warranty of              *");
		System.out.println("* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               *");
		System.out.println("* GNU General Public License for more details.                                *");
		System.out.println("*                                                                             *");
		System.out.println("* You should have received a copy of the GNU General Public License           *");
		System.out.println("* along with this program. If not, see <http://www.gnu.org/licenses/>.        *");
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
		System.out.println("*                                                                             *");
		System.out.println("* -h              Help screen.                                                *");
		System.out.println("* -help           Help screen.                                                *");
		System.out.println("*                                                                             *");
		System.out.println("* -g<number>      Number of games (default 10 000 000).                       *");
		System.out.println("* -p<number>      Progress on each iteration number (default 10 000 000).     *");
		System.out.println("*                                                                             *");
		System.out.println("* -freeoff        Switch off free spins.                                      *");
		System.out.println("* -wildsoff       Switch off wilds.                                           *");
		System.out.println("* -bruteforce     Switch on brute force only for the base game.               *");
		System.out.println("*                                                                             *");
		System.out.println("* -verify         Print input data structures.                                *");
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
	}

	/**
	 * Print all simulation input data structures.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void printDataStructures() {
		System.out.println("Paytable:");
		for (int i = 0; i < paytable.length; i++) {
			System.out.print("\t" + i + " of");
		}
		System.out.println();
		for (int j = 0; j < paytable[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < paytable.length; i++) {
				System.out.print(paytable[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Lines:");
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[0].length; j++) {
				System.out.print(lines[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Base Game Reels:");
		for (int i = 0; i < baseReels.length; i++) {
			for (int j = 0; j < baseReels[i].length; j++) {
				if (j % 10 == 0) {
					System.out.println();
				}
				System.out.print(symbolsNames[baseReels[i][j]] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Free Games Reels:");
		for (int i = 0; i < freeReels.length; i++) {
			for (int j = 0; j < freeReels[i].length; j++) {
				if (j % 10 == 0) {
					System.out.println();
				}
				System.out.print(symbolsNames[freeReels[i][j]] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Base Game Reels:");
		/* Count symbols in reels. */ {
			int[][] counters = {

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			};
			for (int i = 0; i < baseReels.length; i++) {
				for (int j = 0; j < baseReels[i].length; j++) {
					counters[i][baseReels[i][j]]++;
				}
			}
			for (int i = 0; i < baseReels.length; i++) {
				System.out.print("\tReel " + (i + 1));
			}
			System.out.println();
			for (int j = 0; j < counters[0].length; j++) {
				System.out.print(symbolsNames[j] + "\t");
				for (int i = 0; i < counters.length; i++) {
					System.out.print(counters[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------");
			System.out.print("Total:\t");
			long combinations = 1L;
			for (int i = 0; i < counters.length; i++) {
				int sum = 0;
				for (int j = 0; j < counters[0].length; j++) {
					sum += counters[i][j];
				}
				System.out.print(sum + "\t");
				if (sum != 0) {
					combinations *= sum;
				}
			}
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println("Combinations:\t" + combinations);
		}
		System.out.println();

		System.out.println("Free Games Reels:");
		/* Count symbols in reels. */ {
			int[][] counters = {

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			};
			for (int i = 0; i < freeReels.length; i++) {
				for (int j = 0; j < freeReels[i].length; j++) {
					counters[i][freeReels[i][j]]++;
				}
			}
			for (int i = 0; i < freeReels.length; i++) {
				System.out.print("\tReel " + (i + 1));
			}
			System.out.println();
			for (int j = 0; j < counters[0].length; j++) {
				System.out.print(symbolsNames[j] + "\t");
				for (int i = 0; i < counters.length; i++) {
					System.out.print(counters[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------");
			System.out.print("Total:\t");
			long combinations = 1L;
			for (int i = 0; i < counters.length; i++) {
				int sum = 0;
				for (int j = 0; j < counters[0].length; j++) {
					sum += counters[i][j];
				}
				System.out.print(sum + "\t");
				if (sum != 0) {
					combinations *= sum;
				}
			}
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println("Combinations:\t" + combinations);
		}
		System.out.println();
	}

	/**
	 * Print simulation statistics.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void printStatistics() {
		System.out.println("Won money:\t" + wonMoney);
		System.out.println("Lost money:\t" + lostMoney);
		System.out.println("Total Number of Games:\t" + totalNumberOfGames);
		System.out.println();
		System.out.println("Total RTP:\t" + ((double) wonMoney / (double) lostMoney) + "\t\t"
				+ (100.0D * (double) wonMoney / (double) lostMoney) + "%");
		System.out.println("Base Game RTP:\t" + ((double) baseMoney / (double) lostMoney) + "\t\t"
				+ (100.0D * (double) baseMoney / (double) lostMoney) + "%");
		System.out.println("Free Game RTP:\t" + ((double) freeMoney / (double) lostMoney) + "\t\t"
				+ (100.0D * (double) freeMoney / (double) lostMoney) + "%");
		System.out.println();
		System.out.println("Hit Frequency in Base Game:\t" + ((double) baseGameHitRate / (double) totalNumberOfGames)
				+ "\t\t" + (100.0D * (double) baseGameHitRate / (double) totalNumberOfGames) + "%");
		System.out
				.println("Hit Frequency in Free Game:\t" + ((double) freeGamesHitRate / (double) totalNumberOfFreeGames)
						+ "\t\t" + (100.0D * (double) freeGamesHitRate / (double) totalNumberOfFreeGames) + "%");
		System.out.println("Hit Frequency Base Game into Free Game:\t"
				+ ((double) totalNumberOfFreeGameStarts / (double) totalNumberOfGames) + "\t\t"
				+ (100.0D * (double) (totalNumberOfFreeGameStarts) / (double) totalNumberOfGames) + "%");
		System.out.println("Hit Frequency Free Game into Free Game:\t"
				+ ((double) totalNumberOfFreeGameRestarts / (double) totalNumberOfFreeGameStarts) + "\t\t"
				+ (100.0D * (double) (totalNumberOfFreeGameRestarts) / (double) totalNumberOfFreeGameStarts) + "%");
		System.out.println();
		System.out.println("Max Win in Base Game:\t" + baseMaxWin);
		System.out.println("Max Win in Free Game:\t" + freeMaxWin);

		System.out.println();
		System.out.println();
		System.out.println("Base Game Symbols RTP:");
		System.out.print("\t");
		for (int i = 0; i < baseSymbolMoney.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < baseSymbolMoney[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < baseSymbolMoney.length; i++) {
				System.out.print((double) baseSymbolMoney[i][j] / (double) lostMoney + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Base Game Symbols Hit Rate:");
		System.out.print("\t");
		for (int i = 0; i < baseGameSymbolsHitRate.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < baseGameSymbolsHitRate[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < baseGameSymbolsHitRate.length; i++) {
				System.out.print((double) baseGameSymbolsHitRate[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Base Game Symbols Hit Frequency:");
		System.out.print("\t");
		for (int i = 0; i < baseGameSymbolsHitRate.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < baseGameSymbolsHitRate[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < baseGameSymbolsHitRate.length; i++) {
				System.out.print((double) baseGameSymbolsHitRate[i][j] / (double) totalNumberOfGames + "\t");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Free Games Symbols RTP:");
		System.out.print("\t");
		for (int i = 0; i < freeSymbolMoney.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < freeSymbolMoney[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < freeSymbolMoney.length; i++) {
				System.out.print((double) freeSymbolMoney[i][j] / (double) lostMoney + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Free Games Symbols Hit Frequency:");
		System.out.print("\t");
		for (int i = 0; i < freeGameSymbolsHitRate.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < freeGameSymbolsHitRate[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < freeGameSymbolsHitRate.length; i++) {
				System.out.print((double) freeGameSymbolsHitRate[i][j] / (double) totalNumberOfGames + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Free Games Symbols Hit Rate:");
		System.out.print("\t");
		for (int i = 0; i < freeGameSymbolsHitRate.length; i++) {
			System.out.print("" + i + "of\t");
		}
		System.out.println();
		for (int j = 0; j < freeGameSymbolsHitRate[0].length; j++) {
			System.out.print(symbolsNames[j] + "\t");
			for (int i = 0; i < freeGameSymbolsHitRate.length; i++) {
				System.out.print((double) freeGameSymbolsHitRate[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Print screen view.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void printView() {
		int max = view[0].length;
		for (int i = 0; i < view.length; i++) {
			if (max < view[i].length) {
				max = view[i].length;
			}
		}

		for (int j = 0; j < max; j++) {
			for (int i = 0; i < view.length && j < view[i].length; i++) {
				System.out.print(symbolsNames[view[i][j]] + "   ");
			}

			System.out.println();
		}
	}

	/**
	 * Print simulation execution command.
	 *
	 * @param args
	 *            Command line arguments list.
	 *
	 * @author Todor Balabanov
	 *
	 * @email todor.balabanov@gmail.com
	 *
	 * @date 13 Sep 2017
	 */
	private static void printExecuteCommand(String[] args) {
		System.out.println("Execute command:");
		System.out.println();
		System.out.print("java Main ");
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Application single entry point method.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) {
		printExecuteCommand(args);
		System.out.println();

		long numberOfSimulations = 10000000L;
		long progressPrintOnIteration = 10000000L;

		/*
		 * Parse command line arguments.
		 */
		for (int a = 0; a < args.length; a++) {
			if (args.length > 0 && args[a].contains("-g")) {
				String parameter = args[a].substring(2);

				if (parameter.contains("k")) {
					parameter = parameter.substring(0, parameter.length() - 1);
					parameter += "000";
				}

				if (parameter.contains("m")) {
					parameter = parameter.substring(0, parameter.length() - 1);
					parameter += "000000";
				}

				try {
					numberOfSimulations = Integer.valueOf(parameter);
				} catch (Exception e) {
				}
			}

			if (args.length > 0 && args[a].contains("-p")) {
				String parameter = args[a].substring(2);

				if (parameter.contains("k")) {
					parameter = parameter.substring(0, parameter.length() - 1);
					parameter += "000";
				}

				if (parameter.contains("m")) {
					parameter = parameter.substring(0, parameter.length() - 1);
					parameter += "000000";
				}

				try {
					progressPrintOnIteration = Integer.valueOf(parameter);
					verboseOutput = true;
				} catch (Exception e) {
				}
			}

			if (args.length > 0 && args[a].contains("-freeoff")) {
				freeOff = true;
			}

			if (args.length > 0 && args[a].contains("-wildsoff")) {
				wildsOff = true;
			}

			if (args.length > 0 && args[a].contains("-bruteforce")) {
				bruteForce = true;
			}

			if (args.length > 0 && args[a].contains("-verify")) {
				printDataStructures();
				System.exit(0);
			}

			if (args.length > 0 && args[a].contains("-help")) {
				printHelp();
				System.out.println();
				System.exit(0);
			}

			if (args.length > 0 && args[a].contains("-h")) {
				printHelp();
				System.out.println();
				System.exit(0);
			}
		}

		/*
		 * Calculate all combinations in base game.
		 */
		if (bruteForce == true) {
			reelsStops = new int[] { 0, 0, 0, 0, 0 };
			numberOfSimulations = 1;
			for (int i = 0; i < baseReels.length; i++) {
				numberOfSimulations *= baseReels[i].length;
			}
		}

		/*
		 * Simulation main loop.
		 */
		for (long g = 0L; g < numberOfSimulations; g++) {
			if (verboseOutput == true && g == 0) {
				System.out.println("Games\tRTP\tRTP(Base)\tRTP(Free)");
			}

			/*
			 * Print progress report.
			 */
			if (verboseOutput == true && g % progressPrintOnIteration == 0) {
				try {
					System.out.print(g);
					System.out.print("\t");
					System.out.print(String.format("  %6.2lf", ((double) wonMoney / (double) lostMoney)));
					System.out.print("\t");
					System.out.print(String.format("  %6.2lf", ((double) baseMoney / (double) lostMoney)));
					System.out.print("\t");
					System.out.print(String.format("  %6.2lf", ((double) freeMoney / (double) lostMoney)));
				} catch (Exception e) {
				}
				System.out.println();
			}

			totalNumberOfGames++;

			lostMoney += totalBet;

			singleBaseGame();
		}

		System.out.println("********************************************************************************");
		printStatistics();
		System.out.println("********************************************************************************");
	}

}
