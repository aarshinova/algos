import java.util.ArrayList;

public class IpAddress {
    public static void main(String[] args) {
        System.out.println("Res " + validIPAddresses("1921680"));
    }

    public static ArrayList<String> validIPAddresses(String string) {
        if (string.length() < 4) return new ArrayList<>();
        ArrayList<String> ipAddresses = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {  // 1 19 192
            String first = string.substring(0, i);
            System.out.println("First " + first);
            if (!checkNumberValid(first)) {
                continue;
            }
            for (int j = i + 1; j <= (i + 3) && j <= string.length(); j++) { //
                String second = string.substring(i, j);
                System.out.println("second " + second);
                if (!checkNumberValid(second)) {
                    continue;
                }
                for (int k = j+1; k <= (j+3) && k <= string.length(); k++) { //1921680
                    String third = string.substring(j, k);
                    System.out.println("third " + third);
                    if (!checkNumberValid(third)) {
                        continue;
                    }
                    for (int l = (k+1); l <= (k+3) && l <= string.length(); l++) {
                        String fourth = string.substring(k, l);
                        System.out.println("fourth " + fourth);
                        if (!checkNumberValid(fourth)) {
                            continue;
                        }
                        String ipAddress = first.concat(".").concat(second).concat(".").concat(third).concat(".").concat(fourth);
                        System.out.println("result  " + ipAddress);
                        if ((ipAddress.length() - 3) == string.length()) {
                            ipAddresses.add(ipAddress);
                        }
                    }
                }
            }
        }
        return ipAddresses;
    }

    public static boolean checkNumberValid(String numb) {
        if (Integer.parseInt(numb) > 255) {
            return false;
        }
        if (numb.length() >= 2 && numb.charAt(0) == '0') {
            System.out.println("numb is " + numb);
            return false;
        }
        return true;
    }

}

