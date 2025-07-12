package com.example.khulasaquran.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnErrorListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener

@Composable
fun PdfViewBox(
    modifier: Modifier = Modifier,
    assetFileName: String,
    onPageChanged: (Int, Int) -> Unit = { _, _ -> },
    onLoadComplete: (Int) -> Unit = { _ -> },
    onError: (Throwable) -> Unit = { _ -> }
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }
    var pdfView by remember { mutableStateOf<PDFView?>(null) }

    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                PDFView(ctx, null).apply {
                    pdfView = this

                    try {
                        fromAsset(assetFileName)
                            .enableSwipe(true)
                            .swipeHorizontal(true)
                            .pageSnap(true)
                            .autoSpacing(true)
                            .pageFling(true)
                            .spacing(8)
                            .enableDoubletap(true)
                            .defaultPage(0)
                            .enableAnnotationRendering(false) // Disable for better performance
                            .password(null)
                            .scrollHandle(null)
                            .enableAntialiasing(true)
                            .nightMode(false)
                            .onLoad(OnLoadCompleteListener { nbPages ->
                                isLoading = false
                                hasError = false
                                onLoadComplete(nbPages)
                            })
                            .onPageChange(OnPageChangeListener { page, pageCount ->
                                onPageChanged(page, pageCount)
                            })
                            .onError(OnErrorListener { error ->
                                isLoading = false
                                hasError = true
                                onError(error)
                            })
                            .load()
                    } catch (e: Exception) {
                        isLoading = false
                        hasError = true
                        onError(e)
                    }
                }
            },
            update = { view ->
                // Handle updates if needed
            }
        )

        // Loading indicator
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Error handling could be added here if needed
    }

    // Cleanup on disposal
    DisposableEffect(assetFileName) {
        onDispose {
            pdfView?.recycle()
        }
    }
}