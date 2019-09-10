package com.lizz.fundation.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多核CPU高效遍历二叉树
 *
 * @author lizz365
 */
public class CpuTree {
    static Logger logger = LoggerFactory.getLogger(CpuTree.class);
    //线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    //树节点生成总值
    private static int count1 = 0;
    //树节点计算值
    private static volatile AtomicInteger counts = new AtomicInteger(0);

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0); // 以数组第一个元素为根节点
        // 创建/存储二叉树
        CpuTree.createTree(root);
        //开启线程遍历
        executorService.submit(new CountSubNode(root));
        try {
            Thread.sleep(1000);
            logger.debug("count1={}", count1);
            logger.debug("counts={}", counts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }


    /**
     * 遍历线程
     */
    static class CountSubNode implements Callable<Integer> {
        private TreeNode node;

        public CountSubNode(TreeNode node) {
            this.node = node;
        }

        @Override
        public Integer call(){
            int deep = 1;
            do {
                //左节点不为空创建新线程计算
                if (node.left != null) {
                    executorService.submit(new CountSubNode(node.left));
                }
                logger.info("add:{}", node.val);
                //叠加当前节点
                counts.addAndGet(node.val);
                //重置node
                node = node.right;
            } while (node.left != null || node != null);
            return null;
        }
    }

    static class TreeNode {
        //节点值
        int val;
        // 左节点
        TreeNode left;
        // 右节点
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 创建二叉树
     *
     * @param node
     * @return
     */
    public static void createTree(TreeNode node) {
//        if(count1>30)
//            return;
        int num = (int) (Math.random() * 100);
        if (num < 50) {
            count1 += num;
            node.left = new TreeNode(num);
            createTree(node.left);
        }
        num = (int) (Math.random() * 100);
        if (num < 50) {
            count1 += num;
            node.right = new TreeNode(num);
            createTree(node.right);
        }
    }
}


