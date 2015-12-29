#include "order.h"


int main(){ 
char buffer[MAX_SIZE];
    int running = 1;
    int broadcast = 1;    
int cliaddr_len = sizeof( cliaddr );
// Create Socket
     
    if( ( sockfd = socket( AF_INET, SOCK_DGRAM, 0 ) ) == -1 ){
        perror( "Create Sockfd Fail!!\n" );
        exit(1);
    }//if sockfd = socket

    // Setup Broadcast Option
     
    if( ( setsockopt( sockfd, SOL_SOCKET, SO_BROADCAST, &broadcast, sizeof( broadcast ) ) ) == -1 ){
        perror( "Setsockopt - SO_SOCKET Fail!!\n" );
        exit(1);
    }//if setsockopt
//
     
    // Nonblocking   
    make_socket_non_blocking( sockfd );
    // Reset the addresses
     
    memset( &srvaddr, 0, sizeof( srvaddr ) );
    memset( &dstaddr, 0, sizeof( dstaddr ) );



    // Setup the addresses

        srvaddr.sin_family = AF_INET;
        srvaddr.sin_port = htons(RECVPORT);
        srvaddr.sin_addr.s_addr = INADDR_ANY;              

        if( bind( sockfd, (struct sockaddr*) &srvaddr, sizeof( srvaddr ) ) == -1 ){
           perror("bind");
            exit(1);
        }//if bind

    int j;
        while ( running ){  
//---------------------------------------------------------receive
        for (j = 0;j<MAX_SIZE;j++){
            buffer[j] = '\0';
        }
        while( recvfrom( sockfd, buffer, MAX_SIZE, 0,
                                 ( struct sockaddr * )&cliaddr, (socklen_t *)&cliaddr_len ) != -1 ){                    
            json_object *jobj = json_tokener_parse(buffer);        
            json_parse(jobj);            
            }//while recvfrom buffer
        }//while running
        close( sockfd );
        sockfd = -1;
       
}//main