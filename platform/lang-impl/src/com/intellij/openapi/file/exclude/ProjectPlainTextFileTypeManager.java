// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.openapi.file.exclude;

import com.intellij.openapi.components.State;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;

/**
 * @author Rustam Vishnyakov
 */
@State(name = "ProjectPlainTextFileTypeManager")
public class ProjectPlainTextFileTypeManager extends PersistentFileSetManager {
  public static ProjectPlainTextFileTypeManager getInstance(@NotNull Project project) {
    return project.getService(ProjectPlainTextFileTypeManager.class);
  }

  @Override
  protected void onFileAdded(@NotNull VirtualFile file) {
    FileBasedIndex.getInstance().requestReindex(file);
  }

  @Override
  protected void onFileRemoved(@NotNull VirtualFile file) {
    FileBasedIndex.getInstance().requestReindex(file);
  }
}
