package vn.dohoang.cooking;

/**
 * Created by hoangdp on 1/13/2016.
 */
public class AppEnum {
    public enum EIngredientType {
        NONE(0) {
            @Override
            public int colorId() {
                return R.color.color_accent;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_other;
            }

            @Override
            public int stringId() {
                return R.string.app_name;
            }
        },
        SALAD(1) {
            @Override
            public int colorId() {
                return R.color.color_salad;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_salad;
            }

            @Override
            public int stringId() {
                return R.string.text_salad;
            }
        },
        MEAT(2) {
            @Override
            public int colorId() {
                return R.color.color_meat;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_fish;
            }

            @Override
            public int stringId() {
                return R.string.text_meat;
            }
        },
        SPICES(3) {
            @Override
            public int colorId() {
                return R.color.color_spices;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_other;
            }

            @Override
            public int stringId() {
                return R.string.text_spices;
            }
        },
        CHEESE(4) {
            @Override
            public int colorId() {
                return R.color.color_cheese;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_cheese;
            }

            @Override
            public int stringId() {
                return R.string.text_cheese;
            }
        },
        DRINK(5) {
            @Override
            public int colorId() {
                return R.color.color_drink;
            }

            @Override
            public int drawableId() {
                return R.drawable.icon_drink;
            }

            @Override
            public int stringId() {
                return R.string.text_drink;
            }
        };

        public abstract int colorId();

        public abstract int drawableId();

        public abstract int stringId();

        private int mValue;

        private EIngredientType(int value) {
            mValue = value;
        }

        public int getValue() {
            return mValue;
        }
    }

}
