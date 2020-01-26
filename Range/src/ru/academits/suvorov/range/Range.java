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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public String getUnion(Range range2) {
        if (this.from <= range2.to && this.to >= range2.from) {
            double x = Math.min(this.from, range2.from);
            double y = Math.max(this.to, range2.to);

            return "(" + x + " ; " + y + ")";
        }

        return null;
    }

    public String getIntersection(Range range2) {
        if (this.from < range2.to && this.to > range2.from) {
            double x = Math.max(this.from, range2.from);
            double y = Math.min(this.to, range2.to);

            return "(" + x + " ; " + y + ")";
        }

        return null;
    }

    public String[] getDifference(Range range2) {
        if (this.from > range2.from && this.from < range2.to) {
            double x = Math.min(this.to, range2.to);
            double y = Math.max(this.to, range2.to);

            return new String[]{"(" + x + " ; " + y + ")"};
        }
        if (this.to > range2.from && this.to < range2.to) {
            double x = Math.min(this.from, range2.from);
            double y = Math.max(this.from, range2.from);

            return new String[]{"(" + x + " ; " + y + ")"};
        }
        if (range2.from > this.from && range2.to < this.to) {
            double x1 = Math.min(this.from, range2.from);
            double y1 = Math.max(this.from, range2.from);

            double x2 = Math.min(this.to, range2.to);
            double y2 = Math.max(this.to, range2.to);

            return new String[]{"(" + x1 + " ; " + y1 + ")", "(" + x2 + " ; " + y2 + ")"};
        }

        return new String[]{};
    }
}