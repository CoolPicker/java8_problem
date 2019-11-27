package com.cpp;

public class isLogoInVideo {

    public static void main(String[] args) {
        // 凤凰视频
        Rect rect = new Rect(447,19,170,31);
        boolean logoInVideo = isLogoInVideo(640, 360, rect, 4);
//        Rect rect = new Rect(583,1158,113,80);
//        boolean logoInVideo = isLogoInVideo(720, 1280, rect, 2);
        System.out.println(logoInVideo);
    }

    static boolean isLogoInVideo(int w, int h, Rect tmp, int ilabel) {

        if (ilabel != 3 && h > w * 1.2 && tmp.width < 1.01 * tmp.height)  return false;

        float x_norm = (float) (1.0 * tmp.x / w);
        float y_norm = (float) (1.0 * tmp.y / h);
        //float w_norm = 1.0 * tmp.width / w;
        //float h_norm = 1.0 * tmp.height / h;
        int quadr = 0;
        if (x_norm * 3 < 1 ) {
            if (y_norm * 3 < 1 )  quadr = 1;
            if (y_norm * 3 >= 1 && y_norm * 1.5 < 1)  quadr = 4;
            if (y_norm * 1.5 >= 1 && y_norm <= 1) quadr = 7;
        }
        if (x_norm * 3 >= 1 && x_norm * 1.5 < 1 ) {
            if (y_norm * 3 < 1 )  quadr = 2;
            if (y_norm * 3 >= 1 && y_norm * 1.5 < 1)  quadr = 5;
            if (y_norm * 1.5 >= 1 && y_norm <= 1) quadr = 8;
        }
        if (x_norm * 1.5 >= 1 && x_norm <= 1 ) {
            if (y_norm * 3 < 1 )  quadr = 3;
            if (y_norm * 3 >= 1 && y_norm * 1.5 < 1)  quadr = 6;
            if (y_norm * 1.5 >= 1 && y_norm <= 1) quadr = 9;
        }

        if (quadr == 8) {
            if (tmp.y * 1.2 < h) return false;
            return true;
            //return false;
        }
        if (quadr == 1 || quadr == 3) {
            if (!filteredByRule(w, h, tmp, 1))  return false;
            if (!filteredByRule(w, h, tmp, 2))  return false;
            if (!filteredByRule(w, h, tmp, 3))  return false;
            if (!filteredByRule(w, h, tmp, 4))  return false;
//            if (!filteredByRule(w, h, tmp, 5))  return false;

            if (!filteredByRule(w, h, tmp, 11))  return false;
            if (!filteredByRule(w, h, tmp, 13))  return false;
            if (h < w * 1.2 && !filteredByRule(w, h, tmp, 14))  return false;
            if (h < w * 1.2 && !filteredByRule(w, h, tmp, 15))  return false;
            if (ilabel == 3 && tmp.width * tmp.height * 24 > w * h)  return false;
            if (ilabel != 3 && quadr == 1) {
                if ((tmp.x + tmp.width) * 3 < w && tmp.x * 9 > w) return  false;
            }
            //if (ilabel != 3 && quadr == 3) {
            //    if ((w - tmp.x - tmp.width) * 9 > w) return  false;
            //}
            if (h > w * 1.2 && tmp.y * 16 > h)  return false;
            return true;
        }
        if (quadr == 2) {
            //std::cout << "tmp's size is >>>>>>>>>>>>>>>>>>>>>>>>>> " << 1.0 * tmp.height / tmp.width << std::endl;
            if (ilabel == 3 && tmp.width * tmp.height * 36 > w * h)  return false;
            if (ilabel == 3 && tmp.y * 12.0 > h)  return false;
            if (ilabel == 3 && (tmp.y + tmp.height) * 7.0 > h)  return false;
            if (!filteredByRule(w, h, tmp, 1))  return false;
            if (tmp.y * 12 > h)  return false;
            if (tmp.height * 4 > h)  return false;
            if (tmp.width * tmp.height * 18 > w * h)  return false;
            if (!filteredByRule(w, h, tmp, 3))  return false;
            if (h < w * 1.2 && !filteredByRule(w, h, tmp, 4))  return false;
            if (!filteredByRule(w, h, tmp, 5))  return false;
            if (!filteredByRule(w, h, tmp, 10))  return false;
            if (!filteredByRule(w, h, tmp, 11))  return false;
            if (!filteredByRule(w, h, tmp, 13))  return false;
            if (!filteredByRule(w, h, tmp, 14))  return false;
            if (h < w * 1.2 && !filteredByRule(w, h, tmp, 15))  return false;

            if (h > w * 1.2 && tmp.y * 16 > h)  return false;
            if (ilabel != 3 && 1.0 * tmp.height / tmp.width > 0.9)  return false;
            return true;
        }
        if (quadr == 7 || quadr == 9) {
//            if (ilabel == 2)  return false;
//            if (ilabel == 5)  return false;
            if (quadr == 7 && tmp.width * 4 > w)  return false;
//            if (ilabel == 1 && quadr == 7)  return false;
//            if (ilabel == 4 && quadr == 7)  return false;
            if (!filteredByRule(w, h, tmp, 5))  return false;
            if (!filteredByRule(w, h, tmp, 7))  return false;
            if (!filteredByRule(w, h, tmp, 10))  return false;
            if (!filteredByRule(w, h, tmp, 12))  return false;
            if (!filteredByRule(w, h, tmp, 8) && !filteredByRule(w, h, tmp, 9))  return false;
            if (!filteredByRule(w, h, tmp, 13))  return false;
            if (tmp.width * tmp.height * 6 > w * h)  return false;
            if (!filteredByRule(w, h, tmp, 14))  return false;
            if (!filteredByRule(w, h, tmp, 15))  return false;
            if (h > w * 1.2 && (h - tmp.y - tmp.height) * 8 > h)  return false;
            return true;
        }
        if (quadr == 5) {
            if (!filteredByRule(w, h, tmp, 5))  return false;
            if (!filteredByRule(w, h, tmp, 13))  return false;
            if (tmp.width * tmp.height * 20 < w * h)  return false;
            if (tmp.width * tmp.height * 9 > w * h)  return false;
            if (tmp.y * 2 > h)  return false;
            if ((tmp.y + tmp.height) * 2 < h)  return false;
            if (tmp.x * 2 > w)  return false;
            if ((tmp.x + tmp.width) * 2 < w)  return false;
            if (tmp.width * 0.66667 < tmp.height)  return false;
            return true;
        }
        if (quadr == 4 || quadr == 6) {
            if (tmp.width * 4 > w)  return false;
            if (ilabel == 1 && quadr == 4)  return false;
            if (ilabel == 2)  return false;
            if (ilabel == 5)  return false;
            if (tmp.y * 2 < h)  return false;
            if (!filteredByRule(w, h, tmp, 5))  return false;
            if (!filteredByRule(w, h, tmp, 7))  return false;
            if (!filteredByRule(w, h, tmp, 8) && !filteredByRule(w, h, tmp, 9))  return false;
            if (!filteredByRule(w, h, tmp, 10))  return false;
            if (!filteredByRule(w, h, tmp, 12))  return false;
            if (!filteredByRule(w, h, tmp, 13))  return false;
            if (tmp.width * tmp.height * 6 > w * h)  return false;
            if (!filteredByRule(w, h, tmp, 14))  return false;
            if (!filteredByRule(w, h, tmp, 15))  return false;
            return true;
        }
        return false;
    }

    static boolean filteredByRule(int w, int h, Rect tmp, int ruleId) {

        switch (ruleId) {
            case 1:
                if ((tmp.y + tmp.height)*3<h) {
                    return true;
                } else {
                    return false;
                }
            case 2: // rule 2: tmp.y < h / 6
                if (tmp.y * 9 < h) {
                    //std::cout << "goes rule3" << std::endl;
                    return true;
                }else{
                    return false;
                }
            case 3: // rule 3: tmp.width * tmp.height < w * h / 12
                if (tmp.width * tmp.height * 12 < w * h) {
                    //std::cout << "goes rule2" << std::endl;
                    return true;
                }else{
                    return false;
                }
            case 4: // rule 4: tmp.width < w / 3 && tmp.height < h / 3;
                if (tmp.width * 3 < w && tmp.height * 4 < h) {
                    //std::cout << "goes rule5" << std::endl;
                    return true;
                }else{
                    //std::cout << "tmp's rect <<<<<<<<<<<<<<<<< " << tmp.width << "<<<<<<<<<<< " << tmp.height << std::endl;
                    return false;
                }
            case 5: // tmp.widht / tmp.height < 4 && tmp.height / tmp.width < 2
                if (1.0 * tmp.width / tmp.height < 4.7 && 1.0 * tmp.height / tmp.width < 2.0) {
                    //std::cout << "goes rule6" << std::endl;
                    return true;
                }else{
                    //std::cout << "ratio is >>>>>>>>>>>> " << 1.0 * tmp.width / tmp.height << "<<<<<<<<< " << 1.0 * tmp.height / tmp.width << std::endl;
                    return false;
                }
            case 6: // tmp.y > 3h / 4
                if (tmp.y > 0.75*h) {
                    return true;
                }else{
                    //std::cout << "goes rule7" << std::endl;
                    return false;
                }
            case 7: // (h - tmp.y - tmp.height) < h / 6
                if ((h - tmp.y - tmp.height) * 6 < h) {
                    return true;
                }else{
                    //std::cout << "goes rule9" << std::endl;
                    return false;
                }
            case 8: // (tmp.x + tmp.width) < w / 3
                if ((tmp.x + tmp.width)*3 < w) {
                    return true;
                }else{
                    //std::cout << "goes rule8" << std::endl;
                    return false;
                }
            case 9: // tmp.x > 2w / 3
                if (1.5*tmp.x > w) {
                    return true;
                }else{
                    //std::cout << "goes rule8" << std::endl;
                    return false;
                }
            case 10: {//
                float lt = (float) (w/2.0 - tmp.x);
                float rt = (float) (w/2.0 - tmp.x - tmp.width);
                if (lt * rt < 0) {
                    if (lt < 0) lt = -lt;
                    if (rt < 0) rt = -rt;
                    if (lt / rt > 0.33333 && lt / rt < 3 ) {
                        //std::cout << "goes rule4" << std::endl;
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    return true;
                }
            }
            case 11:
                if (1.0 * tmp.y / tmp.height < 1.5) {
                    return true;
                }else {
                    return false;
                }
            case 12:
                if (1.0 * (h - tmp.y -tmp.height) / tmp.height < 1.2) {
                    return true;
                }else {
                    return false;
                }
            case 13:
                if (16 * 16 * tmp.height * tmp.width > w * h ) {
                    return true;
                }else {
                    return false;
                }
            case 14:
                if (tmp.x * 6 < w) {
                    if ((tmp.x + tmp.width) * 3 > w) {
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    return true;
                }
            case 15:
                if ((w - tmp.x - tmp.width) * 6 < w) {
                    if (tmp.x * 1.5 < w){
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    return true;
                }
            default:
                break;
        }
        return false;
    }

    static class Rect{
        public Rect(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Rect() {}

        int x;
        int y;
        int width;
        int height;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
