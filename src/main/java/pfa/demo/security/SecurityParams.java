package pfa.demo.security;

public interface SecurityParams {
     String JWT_HEADER_NAME="Authorization";
  String SECRET="sirine";
   long EXPIRATION=1000*24*3600;
   String HEADER_PREFIX="Bearer ";
}
