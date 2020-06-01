import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 编译原理里的词法分析，语法分析
 */
public class Interpreter {

    /**
     * 环境（Context）角色
     */
    public static class Calculator {

        //定义表达式
        private AbstractExpression expression;

        //构造函数传参，并解析
        public Calculator(String expStr) {
            //安排运算先后顺序
            Stack<AbstractExpression> stack = new Stack<>();
            //表达式拆分为字符数组
            char[] charArray = expStr.toCharArray();

            AbstractExpression left = null;
            AbstractExpression right = null;
            for(int i=0; i<charArray.length; i++) {
                switch (charArray[i]) {
                case '+':    //加法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':    //减法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:    //公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
                }
            }
            this.expression = stack.pop();
        }

        //计算
        public int run(HashMap<String, Integer> var) {
            return this.expression.interpreter(var);
        }
    }

    /**
     * 抽象表达式（Abstract Expression）角色
     */
    public static abstract class AbstractExpression {
        //解析公式和数值，key是公式中的参数，value是具体的数值
        public abstract int interpreter(HashMap<String, Integer> var);
    }

    /**
     * 变量解析器
     */
    public static class VarExpression extends AbstractExpression {

        private String key;

        public VarExpression(String key) {
            this.key = key;
        }

        @Override
        public int interpreter(HashMap<String, Integer> var) {
            return var.get(this.key);
        }
    }

    /**
     * 抽象运算符号解析器
     */
    public static class SymbolExpression extends AbstractExpression {

        protected AbstractExpression left;
        protected AbstractExpression right;

        public SymbolExpression(AbstractExpression left, AbstractExpression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpreter(HashMap<String, Integer> var) {
            // TODO Auto-generated method stub
            return 0;
        }
    
    }

    /**
     * 加法解析器
     */
    public static class AddExpression extends SymbolExpression {

        public AddExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }
    
        public int interpreter(HashMap<String, Integer> var) {
            return super.left.interpreter(var) + super.right.interpreter(var);
        }
    }

    /**
     * 减法解析器
     */
    public static class SubExpression extends SymbolExpression {

        public SubExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }
    
        public int interpreter(HashMap<String, Integer> var) {
            return super.left.interpreter(var) - super.right.interpreter(var);
        }
    }

    /**
     * 客户端（Client）
     */
    public static void main(String[] args) {
        String expStr = "a+b-c";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 3);
        map.put("c", 2);
        Calculator calculator = new Calculator(expStr);
        System.out.println(calculator.run(map));
    }
}