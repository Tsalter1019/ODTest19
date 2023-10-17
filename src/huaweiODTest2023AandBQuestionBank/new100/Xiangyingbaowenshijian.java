package huaweiODTest2023AandBQuestionBank.new100;

/**
 * 响应报文时间
 * 题目描述
 * IGMP 协议中，有一个字段称作最大响应时间(Max Response Time)，HOST收到查询报文，解析出MaxResponseTime字段后，
 * 需要在(0,MaxResponseTime)(s)时间内选取随机时间回应一个响应报文，如果再随机时间内收到一个新的查询报文，则会根据两者时间的大小，
 * 选取小的一方刷新回应时间。
 *
 * 最大响应时间有如下计算方式：
 * 当MaxRespCode < 128,MaxRespTime = MaxRespCode;
 * 当MaxRespCode >= 128,MaxRespTime = (amnt | 0x10) << (exp + 3);
 * |0|123|4567|
 * |1|exp|mant|
 * 注：exp最大响应时间的高5~7位;mant为最大响应时间的低4位。
 * 其中接收到的 MaxRespCode 最大值为255，以上出现所有字段均为无符号数。
 * 现在我们认为 HOST 接收到查询报文时，选取的随机时间必定为最大值。
 * 现给出 HOST 收到查询报文个数 C C </
 */
public class Xiangyingbaowenshijian {
    public static void main(String[] args) {

    }
}