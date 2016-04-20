import java.security.MessageDigest;

class Hash{
    public static void main(String[] args) throws Exception{

	MessageDigest m = MessageDigest.getInstance("MD5");
	StringBuffer s = new StringBuffer();
	StringBuffer key = new StringBuffer("abcdef");
	int count = 0;
	byte[] b;

	while(count <609043){//s.length() < 5 || s.substring(0, 5) != "00000"){
	    s.delete(0, s.length());
	    b = (m.digest(key.toString().getBytes()));

	    for(int i= 0; i < b.length; i ++){
		s.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    if(count != 0){
		key.delete(key.length() - (count + "").length(), key.length());
	    }
	    count++;
	    key.append(count);

	}

	System.out.println (s);
    }
}
