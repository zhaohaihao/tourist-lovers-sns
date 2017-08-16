package com.bigsea.sns.util.base;

import java.util.Random;

/**
 * 随机数操作常用方法集
 * Created by zhh on 2017/08/16.
 */
public class RandomUtils {
	
	/**
	 * 生成指定区间随机数 (min, max)
	 * @param min 区间最小值(不包含)
	 * @param max 区间最大值(不包含)
	 * @return
	 */
	public static int genNum(int min, int max) {
		if (min >= max - 1) {
			throw new IllegalArgumentException("Random num error.");
		}
		Random random = new Random();
		return random.nextInt(max - min - 1) + min + 1;
	}

	/**
	 * 生成指定区间随机数 [min, max)
	 * @param min 区间最小值(包含)
	 * @param max 区间最大值(不包含)
	 * @return
	 */
	public static int genNumIncludeMin(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Random num error.");
		}
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	/**
	 * 生成指定区间随机数 (min, max]
	 * @param min 区间最小值(不包含)
	 * @param max 区间最大值(包含)
	 * @return
	 */
	public static int genNumIncludeMax(int min, int max) {
		return genNumIncludeMin(min, max) + 1;
	}

	/**
	 * 生成指定区间随机数 [min, max]
	 * @param min 区间最小值(包含)
	 * @param max 区间最大值(包含)
	 * @return
	 */
	public static int genNumIncludeMinAndMax(int min, int max) {
		if (min >= max + 1) {
			throw new IllegalArgumentException("Random num error.");
		}
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	/**
	 * 生成指定长度随机数
	 * @param len 指定长度
	 * @return
	 */
	public static int genNumByLen(int len) {
		if (len < 1 || len > 9) {
			throw new IllegalArgumentException("Random num error.");
		}
		return Integer.valueOf(genNumStrByLen(len));
	}

	/**
	 * 生成指定长度随机数
	 * @param len 指定长度
	 * @return
	 */
	public static String genNumStrByLen(int len) {
		if (len < 1) {
			throw new IllegalArgumentException("Random num error.");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				sb.append(genNumIncludeMax(0, 9));
			} else {
				sb.append(genNumIncludeMinAndMax(0, 9));
			}
		}
		return sb.toString();
	}
}
