import os
import urllib.parse
from http.server import SimpleHTTPRequestHandler

class CORSRequestHandler(SimpleHTTPRequestHandler):
    def end_headers(self):
        self.send_header('Access-Control-Allow-Origin', '*')  # Allow requests from any origin
        self.send_header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')  # Allow specific HTTP methods
        self.send_header('Access-Control-Allow-Headers', 'Content-Type')  # Allow specific headers
        super().end_headers()

    def do_OPTIONS(self):
        self.send_response(200)
        self.end_headers()

    def do_PUT(self):
        content_length = int(self.headers['Content-Length'])
        file_name = os.path.basename(urllib.parse.unquote(self.path))

        with open(file_name, 'wb') as file:
            file.write(self.rfile.read(content_length))

        self.send_response(200)
        self.end_headers()

if __name__ == '__main__':
    from http.server import HTTPServer

    server_address = ('', 8000)
    httpd = HTTPServer(server_address, CORSRequestHandler)
    print('Server running on http://localhost:8000/')
    httpd.serve_forever()
