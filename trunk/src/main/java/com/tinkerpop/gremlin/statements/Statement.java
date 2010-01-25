package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class Statement {

    public int lineNumber;
    protected XPathEvaluator xPathEvaluator;
    protected boolean complete = false;
    private String rawStatement = new String();

    public Statement(final XPathEvaluator xPathEvaluator) {
        this.xPathEvaluator = xPathEvaluator;
        this.lineNumber = this.xPathEvaluator.getCurrentLineNumber();
    }

    public void compileTokens(final String line) {
        this.rawStatement = this.rawStatement + Tokens.SINGLESPACE + line.trim();
    }

    public abstract List evaluate();

    public boolean isComplete() {
        return complete;
    }

    public String toString() {
        return this.rawStatement;
    }

}
