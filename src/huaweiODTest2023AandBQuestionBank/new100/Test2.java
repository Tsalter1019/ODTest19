package huaweiODTest2023AandBQuestionBank.new100;

/**
 * 告警抑制
 * 是指高优先级告警抑制低优先级告警的规则。高优先级告警产生后，低优先级不再产生。
 * 请根据告警列表和告警抑制关系，给出实际产生的告警列表
 * 不会出现循环抑制的情况
 * 告警不会传递比如 A>B,B>C,这种情况A不会直接抑制C。但被抑制的告警仍然可以抑制其他低优先级告警
 *
 * 输入
 * 第一行为数字N  表示告警抑制关系个数，
 * 接下来N行，每行是由空格分隔的两个告警ID
 *
 * 输入
 * 2
 * A B
 * B C
 * A B C D E
 * 输出
 * A D E
 *
 */
public class Test2 {
    public static void main(String[] args) {

    }
}