/*
package com.junit5.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

*/
/**
 * jdk8 集合Stream流练习
 * 对于List<Integer>类似的简单类型的少数据量集合处理 不适用适用sream操作，效率比for循环迭代效率低
 * for循环是JIT的主要优化流程
 *//*

public class CollecStream {
    public static void main(String[] args) {
        List<Transcation> transList=new ArrayList<>(10);
        transList.add(new Transcation("1","1",new BigDecimal("50"),"20201120","130320"));
        transList.add(new Transcation("2","1",new BigDecimal("100"),"20201119","125920"));
        transList.add(new Transcation("3","1",new BigDecimal("150"),"20201120","131330"));
        transList.add(new Transcation("4","1",new BigDecimal("500"),"20201120","131330"));
        transList.add(new Transcation("5","1",new BigDecimal("500"),"20201120","131331"));
        transList.add(new Transcation("6","1",new BigDecimal("600"),"20201120","131430"));
        transList.add(new Transcation("7","1",new BigDecimal("1000"),"20201020","132330"));
        transList.add(new Transcation("8","2",new BigDecimal("100"),"20201120","111330"));
        transList.add(new Transcation("9","2",new BigDecimal("200"),"20201120","031330"));
        transList.add(new Transcation("10","2",new BigDecimal("700"),"20201120","131331"));

*/
/*        transList.forEach( trans -> {
            trans.setTxTyp(TxTyp.getDescByTxTyp(trans.getTxTyp()));
            System.out.println(JSON.toJSONString(trans));

                }

        );*//*


        System.out.println("sortByTxAmt: "+JSON.toJSONString(sortByTxAmt(transList)));
        System.out.println("sortByTxAmtTxTm: "+JSON.toJSONString(sortByTxAmtTxTm(transList)));
        System.out.println("findDistinctTxTyp: "+JSON.toJSONString(findDistinctTxTyp(transList)));
        System.out.println("findTop5: "+JSON.toJSONString(findTop5(transList)));
        System.out.println("txTypTransform: "+JSON.toJSONString(txTypTransform(transList)));


    }

    */
/**
     * transList.stream()表示串行流 单核cpu 大数据量复杂操作效率较高
     * 筛选交易类型是退款的并且按照金额从小到大排序
     * @param transList
     * @return
     *//*

    public static List<Transcation> sortByTxAmt(List<Transcation> transList){
        return transList.stream()
                .filter(x -> x.getTxTyp() == TxTyp.REFUND.getTxTyp())
                .sorted(Comparator.comparing(Transcation::getTxDt))
                .collect(Collectors.toList());
    }

    */
/**
     * transList.parallelStream()表示并行流  大数据量多核cpu的复杂操作效率较高
     * 筛选交易类型是消费的并且按照先金额从大到小排序，再按交易日期倒序再按照交易时间排序 只输出流水号
     * @param transList
     * @return
     *//*

    public static List<String> sortByTxAmtTxTm(List<Transcation> transList){
        //此函数式接口表示输入Transcation 返回其getTxAmt()
        //与使用双冒号::的语法糖形式相同   .map(Transcation::getTxAmt)
        Function<Transcation,String> transToJrnNo= func -> {
            return func.getJrnNo();
        };
        return transList.parallelStream()
                .filter(x -> x.getTxTyp() == TxTyp.CONSUME.getTxTyp())
                .sorted(Comparator.comparing(Transcation::getTxAmt).reversed()
                        .thenComparing(Transcation::getTxDt).reversed()
                        .thenComparing(Transcation::getTxTm).reversed())
                .map(transToJrnNo)
                //.map(Transcation::getTxAmt) 与使用上面的方式相同
                .collect(Collectors.toList());
    }

    */
/**
     * 筛选所有不同的交易类型
     * @param transList
     * @return
     *//*

    public static List<String> findDistinctTxTyp(List<Transcation> transList){
        return transList.parallelStream()
                .map(Transcation::getTxTyp)
                .distinct()
                .collect(Collectors.toList());
    }

    */
/**
     * 筛选出消费金额大于100的前5的流水号 并用逗号连接
     * @param transList
     * @return
     *//*

    public static String findTop5(List<Transcation> transList){
        return transList.stream()
                .filter(trans -> trans.getTxAmt().compareTo(new BigDecimal("100")) > 0
                        && trans.getTxTyp() == TxTyp.CONSUME.getTxTyp())
                .sorted(Comparator.comparing(Transcation::getTxAmt).reversed())
                .limit(5)
                .map(Transcation::getJrnNo)
                .collect(Collectors.joining(","));
    }


    */
/**
     * @param transList
     * @return
     *//*

    public static List<Transcation> txTypTransform(List<Transcation> transList){
        List<Transcation> resultList=new ArrayList<>(transList.size());
        transList.stream()
                .forEach(trans -> {
                    trans.setTxTyp(TxTyp.getDescByTxTyp(trans.getTxTyp()));
                    resultList.add(trans);
                });
        return resultList;
    }


    */
/**
     * 定义交易实体类
     *//*

    @Data
    static class Transcation {
        Transcation(String jrnNo,String txTyp,BigDecimal txAmt,String txDt,String txTm){
            this.jrnNo=jrnNo;
            this.txTyp=txTyp;
            this.txAmt=txAmt;
            this.txDt=txDt;
            this.txTm=txTm;
        }
        private String jrnNo;
        private String txTyp;
        private BigDecimal txAmt;
        private String txDt;
        private String txTm;
    }
    enum TxTyp{
        CONSUME("1","消费"),
        REFUND("2","退款"),
        ;
        private final String txTyp;
        private final String desc;
        TxTyp(String txTyp,String desc){
            this.txTyp=txTyp;
            this.desc=desc;
        }
        public String getTxTyp(){return this.txTyp;}
        public String getDesc(){return this.desc;}
        public static String getDescByTxTyp(String txTyp){
            for(TxTyp txTyp1:values()){
                if(StringUtils.equals(txTyp,txTyp1.getTxTyp())){
                    return txTyp1.getDesc();
                }
            }
            return null;
        }
    }

}
*/
