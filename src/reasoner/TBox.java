package reasoner;

import reasoner.expressions.Expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TBox contains all the expressions connected to a single expression.
 * 
 * Example Usage:
 * "John is rich"
 * "John is British"
 * The TBox will contain "John" and a set of expressions "rich" and "British"
 * 
 * @author Brian Fung
 * @author Jon Miranda
 * @author Sravani Mudduluru
 * @author Siavash Rezaie
 */
public class TBox extends HashMap<Expression, Set<Expression>> {

  public void add(SubsumptionEquivalence subsumptionEquivalence) {
    Expression lhs = subsumptionEquivalence.lhs;
    Expression rhs = subsumptionEquivalence.rhs;

    Set<Expression> currentRhs = get(lhs);
    if (currentRhs == null) {
      currentRhs = new HashSet<>();
    }
    currentRhs.add(rhs);
    put(lhs, currentRhs);
  }

 /**
  * Returns the TBox as a String
  *
  * @return the TBox as a String
  */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("========== TBOX START ==========\n");
    for (Map.Entry<Expression, Set<Expression>> values : this.entrySet()) {
      sb.append(values.getKey());
      sb.append("={");
      for (Expression e : values.getValue()) {
        sb.append(e);
        sb.append(",");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append("}\n");
    }
    sb.append("========== TBOX END ==========\n");
    return sb.toString();
  }
}
