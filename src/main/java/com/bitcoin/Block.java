package com.bitcoin;

import java.util.List;

/**
 * 比特币时构建在区块链技术之上的一个加密数字货币，区块链顾名思义即由很多区块组成的链条，
 * 可以把区块链简单比喻为一本账本，把区块比喻为账本的一页记录，账本的每一页里都记录了很多比特币的转账记录。
 *
 * 区块结构
 */
public class Block {

    /**
     * 区块索引号
     */
    private int index;

    /**
     * 当前区块的hash值，区块唯一标识
     */
    private String hash;

    /**
     * 生成区块的时间戳
     */
    private long timestamp;

    /**
     * 当前区块的交易集合
     */
    private List<Transaction> transactions;

    /**
     * 工作量证明，计算正确hash值的次数
     */
    private int nonce;

    /**
     * 前一个区块的hash值
     */
    private String previousHash;

    public Block() {
        super();
    }

    public Block(int index, String hash, long timestamp, List<Transaction> transactions, int nonce, String previousHash) {
        super();
        this.index = index;
        this.hash = hash;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.nonce = nonce;
        this.previousHash = previousHash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
}
