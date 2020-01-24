package ru.academits.suvorov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength1() {
        return this.to - this.from;
    }

    public double getLength2(double from, double to) {
        return to - from;
    }

    public boolean isInside1(double number) {
        return number >= from && number <= to;
    }

    public boolean isInside2(double number, double from, double to) {
        return number >= from && number <= to;
    }

    public double[] intervalsAddition(double from, double to) {
        double[] intervalsAdditionResult;

        if (this.from == from && this.to == to) {
            intervalsAdditionResult = new double[]{this.from, this.to};
            return intervalsAdditionResult;
        }
        if (this.from == from) {
            intervalsAdditionResult = new double[]{this.from, Math.min(this.to, to), Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsAdditionResult;
        }
        if (this.to == to) {
            intervalsAdditionResult = new double[]{Math.min(this.from, from), Math.max(this.from, from), Math.max(this.from, from), this.to};
            return intervalsAdditionResult;
        }
        if (this.to == from || to == this.from) {
            intervalsAdditionResult = new double[]{Math.min(this.from, from), Math.max(this.from, from), Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsAdditionResult;
        }
        if (this.from < to && this.to > from) {
            intervalsAdditionResult = new double[]{Math.min(this.from, from), Math.max(this.from, from), Math.max(this.from, from), Math.min(this.to, to), Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsAdditionResult;
        }
        return null;
    }

    public double[] intervalsIntersection(double from, double to) {
        double[] intervalsIntersectionResult;

        if (this.from < to && this.to > from) {
            intervalsIntersectionResult = new double[]{Math.max(this.from, from), Math.min(this.to, to)};
            return intervalsIntersectionResult;
        }
        if (this.to == from) {
            intervalsIntersectionResult = new double[]{this.to};
            return intervalsIntersectionResult;
        }
        if (this.from == to) {
            intervalsIntersectionResult = new double[]{this.from};
            return intervalsIntersectionResult;
        }
        return null;
    }

    public double[] intervalsDifference(double from, double to) {
        double[] intervalsDifferenceResult;

        if (this.from >= from && this.to <= to) {
            intervalsDifferenceResult = new double[]{0};
            return intervalsDifferenceResult;
        }
        if (this.from == from) {
            intervalsDifferenceResult = new double[]{Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsDifferenceResult;
        }
        if (this.to == to) {
            intervalsDifferenceResult = new double[]{Math.min(this.from, from), Math.max(this.from, from)};
            return intervalsDifferenceResult;
        }
        if (this.from > from && this.from < to) {
            intervalsDifferenceResult = new double[]{Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsDifferenceResult;
        }
        if (this.to > from && this.to < to) {
            intervalsDifferenceResult = new double[]{Math.min(this.from, from), Math.max(this.from, from)};
            return intervalsDifferenceResult;
        }
        if (this.from < to && this.to > from) {
            intervalsDifferenceResult = new double[]{Math.min(this.from, from), Math.max(this.from, from), Math.min(this.to, to), Math.max(this.to, to)};
            return intervalsDifferenceResult;
        }
        return null;
    }
}