package com.example.newraspisanie.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;

/**
 * Created by matek on 04.10.2017.
 */

public class RotateTransition extends Transition {

    private static final String PROPNAME_ROTATE = "rotateTransition:rotation";

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_ROTATE, transitionValues.view.getRotation());
    }

    @Override
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    @Override
    public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues) {
        if (startValues != null && endValues != null) {
            float startRotate = (float) startValues.values.get(PROPNAME_ROTATE);
            float endRotate = (float) endValues.values.get(PROPNAME_ROTATE);
            if (startRotate != endRotate) {
                endValues.view.setRotation(startRotate);
                return ObjectAnimator.ofFloat(endValues.view, "rotation", startRotate, endRotate);
            }
        }
        return null;
    }
}
