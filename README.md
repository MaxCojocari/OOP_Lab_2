# Blockchain simulation. Part 1: Encapsulation

![image](https://user-images.githubusercontent.com/92053176/192138851-6466d959-734a-4a0c-ab41-3c604095add6.png)

This project implements a simple analogue of a blockchain system that can deal with transactions, accounts and their balances.

In order to run this project, complete the following steps:

- `git clone git@github.com:MaxCojocari/OOP_Lab_2.git`
- `cd OOP_Lab_2/BlockchainProject`
- `javac -cp src -d out src/dir/*.java`, where `dir = actors, core, crypto, merkletree`
- `javac -cp src -d out src/*.java`
- `java -cp out Simulation`

## System description

The main entities of this system are actors who transact cryptoassets, miners, transactions, transaction pools, cryptoassets, blocks and blockchain itself. They can be enumerated as follows:

- Actors:
  - Sender
  - Receiver
  - Miner 
- Cryptoassets:
   - Ethereum (ETH)
   - Bitcoin (BTC)
- Core architectural elements:
   - Transaction
   - Transaction pool
   - Wallet
   - Block
   - Blockchain
   - Merkle trie (Merkle root)
   
Each actor object has unique fields, but also exhibits common ones which are related to balances of owned assets stored in `Wallet`s. They interact between them through sending different tokens to each other, thus generating multiple transactions which are recorded in `Transaction` objects. Roughly speaking, transactions are objects which contain information about the sender, receiver, the amount of crypto and what kind of asset was sent.

Synchronously, a fixed-size set of transactions is gathered in such called *transaction pools*. In `TransactionPool` object all transactions get accumulated and checked for their correctness and consistency, e.g amount of tokens sent doesn't exceed the actual sender's balance, etc. All sort of checks are done by *miners* while they cluster transactions into so called *blocks*, and then *mine* them.

But before this, in the header of the block is inserted a *Merkle root* hash which is derived from *Merkle tree* data structure. A Merkle tree is a data structure which totals all transactions in a block and generates a digital fingerprint of the entire set of operations, allowing the user to verify whether it includes a transaction in the block. For more info check [here](https://en.wikipedia.org/wiki/Merkle_tree).

Only after that the mining happens. 

*Mining* is a process of solving complex cryptographic hash puzzles to verify blocks of transactions updated on the decentralized blockchain ledger. *Miners* are actors who try to solve this conundrum. The first who will be done will receive a reward in terms of cryptocurrency (in this project BTC).

After all these steps, the mined block is added to the *blockchain* which is represented in my project by `Blockchain` object. Only after the block is mined and the block is finally chained to the whole system, the transaction will be confirmed and finished.

The whole workflow in blockchain system can be resumed in picture below.

![image](https://user-images.githubusercontent.com/92053176/192143455-78da7c7f-f1be-4cf8-8498-434580929c2a.png)

## Project structure

The `BlockchainProject` consists of `src` folder with `Simulation.java` file where all magic happens and another four folders:
  - `src/actors`
    - `Miner.java`
    - `Receiver.java`
    - `Sender.java`
  - `src/core`
    - `Block.java`
    - `Blockchain.java`
    - `Transaction.java`
    - `TransactionPool.java`
    - `Wallet.java`
  - `src/crypto`
    - `ETHCoin.java`
    - `BTCCoin.java`
  - `src/merkletree`
    - `Leaf.java`
    - `MerkleTree.java`


Each subdirectory contains `.java` objects, each of them representing entities described previously.
