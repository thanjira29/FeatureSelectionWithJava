import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 8/04/17.
 */
public abstract class FeatureSelection {
    /**
    Returns a subset of only the most important features
    chosen by some measure.
     */
   public abstract Set<Integer> select(Set<Instance> instances, int numFeaturesToSelect);

   /**
   Returns a subset containing only the numFeatures most important
    features. If numFeatures is >= original.size(), the original
    set is returned.
    */
   public abstract Set<Integer> select(Set<Instance> instances, double goalAccuracy);

    /**
     * Returns the feature in remaining features
     * which maximises the objective function.
     *
     * @param selectedFeatures
     * @param remainingFeatures
     * @return
     */
    protected int max(Set<Instance> instances, Set<Integer> selectedFeatures, Set<Integer> remainingFeatures){
        double highest = -Integer.MAX_VALUE;
        int selected = -1;

        for(int feature: remainingFeatures){
            double result = objectiveFunction(instances, selectedFeatures, feature);
            if(result > highest){
                highest = result;
                selected = feature;
            }
        }

        return selected;
    }

    protected double objectiveFunction(Set<Instance> instances, Set<Integer> selectedFeatures) {
        return 0;
    }

    protected double objectiveFunction(Set<Instance> instances, Set<Integer> selectedFeatures, int feature) {
        Set<Integer> features = new HashSet<>(selectedFeatures);
        features.add(feature);
        return objectiveFunction(instances, features);
    }


}
