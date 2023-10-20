import 'package:http/http.dart';
import 'package:http_interceptor/http_interceptor.dart';
import 'package:pudim_douro/http/interceptors/logging_interceptor.dart';

final Client client = InterceptedClient.build(interceptors: [
  LoggingInterceptor(),
]);

final Uri baseUrl = Uri.http('192.168.15.119:8080', '/api/user');
