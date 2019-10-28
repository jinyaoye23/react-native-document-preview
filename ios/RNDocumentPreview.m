#import "RNDocumentPreview.h"
#import <WebKit/WebKit.h>

@implementation RNDocumentPreview

+(BOOL)requiresMainQueueSetup {
    return YES;
}
    
- (instancetype)init
{
    if (self = [super init]) {
        
    }
    return self;
}

- (UIViewController*) getRootVC {
    UIViewController *root = [[[[UIApplication sharedApplication] delegate] window] rootViewController];
    while (root.presentedViewController != nil) {
        root = root.presentedViewController;
    }
    
    return root;
}

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(preview:(NSString *)filePath) {
    
    UIViewController *ctrl = [[[[UIApplication sharedApplication] delegate] window] rootViewController];
    UIViewController *webviewController = [[UIViewController alloc]init];
    UIWebView *webview = [[UIWebView alloc]initWithFrame:ctrl.view.bounds];
    webview.scalesPageToFit = YES;
    
    NSURL *url = [NSURL URLWithString:filePath];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    [webview loadRequest:request];
    [webviewController.view addSubview:webview];
    UINavigationController *nav = [[UINavigationController alloc]initWithRootViewController:webviewController];
    webviewController.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc]initWithTitle:@"返回" style:UIBarButtonItemStylePlain target:self action:@selector(goBack)];
    nav.modalPresentationStyle = UIModalPresentationFullScreen;
    [[self getRootVC] presentViewController:nav animated:YES completion:nil];
}

-(void)goBack {
    [[self getRootVC] dismissViewControllerAnimated:YES completion:nil];
}



@end
  
