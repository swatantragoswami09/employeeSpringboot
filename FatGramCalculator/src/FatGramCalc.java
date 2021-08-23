
public class FatGramCalc {
	
	double totalNumberOfCalories;
	double fatGrams;
	double caloriesFromFat;
	double percentageOfCaloriesFromFat;
	
	public double getTotalNumberOfCalories() {
		return totalNumberOfCalories;
	}
	
	public void setTotalNumberOfCalories(double totalNumberOfCalories) {
		this.totalNumberOfCalories = totalNumberOfCalories;
	}
	
	public double getFatGrams() {
		return fatGrams;
	}
	
	public void setFatGrams(double fatGrams) {
		this.fatGrams = fatGrams;
	}
	
	public double getCaloriesFromFat() {
		return caloriesFromFat;
	}
	
	public void setCaloriesFromFat(double caloriesFromFat) {
		this.caloriesFromFat = caloriesFromFat;
	}
	
	public double getPercentageOfCaloriesFromFat() {
		return percentageOfCaloriesFromFat;
	}
	
	public void setPercentageOfCaloriesFromFat(double percentageOfCaloriesFromFat) {
		this.percentageOfCaloriesFromFat = percentageOfCaloriesFromFat;
	}
	
	@Override
	public String toString() {
		return "FatGramCalc [totalNumberOfCalories=" + totalNumberOfCalories + ", fatGrams=" + fatGrams
				+ ", caloriesFromFat=" + caloriesFromFat + ", percentageOfCaloriesFromFat="
				+ percentageOfCaloriesFromFat + "]";
	}
	

}
