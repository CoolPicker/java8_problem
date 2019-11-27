package com.bitcoin;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 区块链工具类
 *
 * 挖矿：
 *     Hash = SHA-256（区块链的最后一个区块的Hash +　需记账交易记录信息　＋　随机数）
 *
 *
 */
public class BlockChainUtils {

    /**
     * 挖矿
     * @param blockChain 整个区块链
     * @param txs 需记账交易记录
     * @param address 矿工钱包地址
     */
    private static void mineBlock(
            List<Block> blockChain,
            List<Transaction> txs,
            String address) {
        // 加入系统奖励，默认挖矿奖励25个比特币
        Transaction sysTx = new Transaction(UUID.randomUUID().toString(),
                "",
                address,
                25);
        txs.add(sysTx);
        // 获取当前区块链里的最后一个区块
        Block latestBlock = blockChain.get(blockChain.size() - 1);
        // 随机数
        int nonce = 1;
        String hash = "";
        while (true) {
            hash = CryptoUtil.getSHA256(latestBlock.getHash()
                + JSON.toJSONString(txs) + nonce);
            if (hash.startsWith("0000")) {
                System.out.println(" ===== 计算结果正确，计算次数为： " + nonce + ",hash: " + hash);
                break;
            }
            nonce++;
            System.out.println("计算错误，hash： " + hash);
        }

        // 解出难题，可以构建新区块并加入到区块链中
        Block newBlock = new Block(latestBlock.getIndex() + 1,
                hash,
                System.currentTimeMillis(),
                txs,
                nonce,
                latestBlock.getHash());
        blockChain.add(newBlock);
        System.out.println("挖矿后的区块链： " + JSON.toJSONString(blockChain));
    }

    /**
     * 查询余额
     * @param blockChain
     * @param address
     * @return
     */
    public static int getWalletBalance(List<Block> blockChain,String address) {
        int balance = 0;
        for (Block block : blockChain) {
            List<Transaction> transactions = block.getTransactions();
            for (Transaction transaction : transactions) {
                if (address.equals(transaction.getRecipient())) {
                    balance += transaction.getAmount();
                }
                if (address.equals(transaction.getSender())) {
                    balance -= transaction.getAmount();
                }
            }
        }
        return balance;
    }

    public static void main(String[] args) {
        // 创建一个空的区块链
        List<Block> blockChain = new ArrayList<>();
        // 生成创世区块
        Block block = new Block(1,"1",System.currentTimeMillis(),new ArrayList<Transaction>(),1,"1");

        blockChain.add(block);
        System.out.println(JSON.toJSONString(blockChain));

        String sender = "sender_wallet";
        String recipient = "recipient_wallet";

        List<Transaction> txs = new ArrayList<>();

        mineBlock(blockChain,txs,sender);
        System.out.println(sender + "钱包余额为： " + getWalletBalance(blockChain,sender));

        List<Transaction> txs1 = new ArrayList<>();
        Transaction tx1 = new Transaction(UUID.randomUUID().toString(),sender,recipient,3);
        Transaction tx2 = new Transaction(UUID.randomUUID().toString(),sender,recipient,1);
        txs1.add(tx1);
        txs1.add(tx2);

        mineBlock(blockChain,txs1,sender);
        System.out.println(sender + "钱包余额为： " + getWalletBalance(blockChain,sender));
        System.out.println(recipient + "钱包余额为： " + getWalletBalance(blockChain,recipient));
    }

}
